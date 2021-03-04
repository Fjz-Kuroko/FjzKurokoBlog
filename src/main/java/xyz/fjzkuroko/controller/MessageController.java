package xyz.fjzkuroko.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.fjzkuroko.dto.ResponseMessage;
import xyz.fjzkuroko.entity.Message;
import xyz.fjzkuroko.service.MessageService;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @PostMapping("/addMessage")
    public ResponseMessage addMessage(@Valid Message message, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            for (FieldError item : fieldErrors) {
                errors.put(item.getField(), item.getDefaultMessage());
            }
            return ResponseMessage.newErrorInstance("表单验证错误！", errors);
        }
        int i = messageService.addMessage(message);
        if (i > 0) {
            return ResponseMessage.newOkInstance("留言成功！");
        } else {
            return ResponseMessage.newErrorInstance("留言失败！");
        }
    }

}
