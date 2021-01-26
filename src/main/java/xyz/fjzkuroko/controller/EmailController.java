package xyz.fjzkuroko.controller;

import xyz.fjzkuroko.dto.ResponseData;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.fjzkuroko.dto.ResponseMessage;
import xyz.fjzkuroko.util.EhcacheUtil;
import xyz.fjzkuroko.util.EmailUtil;

import java.util.Random;

@RestController
@RequestMapping("/email")
public class EmailController {

    @PostMapping("/code")
    public ResponseMessage code(String email) {
        if (email == null || "".equals(email)) {
            return ResponseMessage.newErrorInstance("邮箱不能为空！");
        }
        String code = getRandomCode();
        if (EmailUtil.sendEmail(email, code)) {
            EhcacheUtil.insertEmailCode(email, code);
            return ResponseMessage.newOkInstance(null, "验证码发送成功！");
        }
        return ResponseMessage.newErrorInstance("验证码发送失败！");
    }

    public static String getRandomCode() {
        String str="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb=new StringBuilder(4);
        for(int i = 0; i < 4; i++)
        {
            char ch=str.charAt(new Random().nextInt(str.length()));
            sb.append(ch);
        }
        return sb.toString();
    }

}
