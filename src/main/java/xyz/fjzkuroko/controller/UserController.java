package xyz.fjzkuroko.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.fjzkuroko.dto.ResponseData;
import xyz.fjzkuroko.dto.ResponseMessage;
import xyz.fjzkuroko.entity.User;
import xyz.fjzkuroko.service.UserService;
import xyz.fjzkuroko.util.EhcacheUtil;
import xyz.fjzkuroko.util.JWTUtil;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseMessage login(@Valid User user, BindingResult bindingResult, String uuid, String checkCode) {
        String captchaCode = EhcacheUtil.getCaptchaCode(uuid);
        if (captchaCode == null) {
            return ResponseMessage.newErrorInstance("验证码已过期！");
        } else if (!captchaCode.equals(checkCode.toLowerCase())) {
            return ResponseMessage.newErrorInstance("验证码错误！");
        }
        ResponseMessage errors = validate(bindingResult);
        if (errors != null) return errors;
        User login = userService.login(user);
        if (login != null) {
            // 生成token
            String token = JWTUtil.generateToken(login.getUsername(), "FjzKurokoBlogIssuer", login.getEmail());
            Map<String, Object> map = new HashMap<>(2);
            login.setPassword("******");
            map.put("user", login);
            map.put("token", token);
            return ResponseMessage.newOkInstance(map, "登录成功");
        }
        return ResponseMessage.newErrorInstance("用户名或密码错误！");
    }

    @PostMapping("/register")
    public ResponseMessage register(@Valid User user, BindingResult bindingResult, String emailCode) {
        if (emailCode == null || "".equals(emailCode)) {
            return ResponseMessage.newErrorInstance("邮箱验证码不能为空！");
        }
        String code = EhcacheUtil.getEmailCode(user.getEmail());
        if (code == null) {
            return ResponseMessage.newErrorInstance("邮箱验证码已过期，请重新获取");
        } else if (!code.equals(emailCode)) {
            return ResponseMessage.newErrorInstance("邮箱验证码错误！");
        }
        ResponseMessage errors = validate(bindingResult);
        if (errors != null) return errors;
        int register = userService.register(user);
        if (register == -1) {
            return ResponseMessage.newErrorInstance("用户名已经存在！");
        }
        if (register > 0) {
            return ResponseMessage.newOkInstance(null, "注册成功！");
        }
        return ResponseMessage.newErrorInstance("注册失败！");
    }

    /**
     * 表单验证
     * @param bindingResult
     * @return
     */
    private ResponseMessage validate(BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            for (FieldError item : fieldErrors) {
                errors.put(item.getField(), item.getDefaultMessage());
            }
            return ResponseMessage.newErrorInstance("表单验证错误！", errors);
        }
        return null;
    }

    @PostMapping("/selectByUsername")
    public ResponseMessage selectByUsername(String username) {
        if (username == null || "".equals(username)) {
            return ResponseMessage.newErrorInstance("用户名不能为空！");
        }
        User user = userService.selectByUsername(username);
        if (user == null) {
            return ResponseMessage.newErrorInstance("用户不存在！");
        }
        return ResponseMessage.newOkInstance(user);
    }

    @PostMapping("/isLogin")
    public ResponseData isLogin(String username, HttpServletRequest request) {
        ResponseData responseData = ResponseData.customerError();
        if (username == null || "".equals(username)) {
            responseData.putDataValue("msg", "用户名不能为空！");
            return responseData;
        }
        if (!JWTUtil.verifyId(username, request)) {
            responseData.putDataValue("msg", "验证错误！请重新登录!");
            return responseData;
        }
        responseData = ResponseData.ok();
        responseData.putDataValue("msg", "已登录");
        return responseData;
    }

}
