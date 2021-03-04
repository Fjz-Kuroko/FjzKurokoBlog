package xyz.fjzkuroko.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import xyz.fjzkuroko.dto.ResponseMessage;
import xyz.fjzkuroko.entity.Comment;
import xyz.fjzkuroko.entity.Reply;
import xyz.fjzkuroko.service.CommentService;
import xyz.fjzkuroko.util.JWTUtil;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @RequestMapping("/getCommentsByAid")
    public ResponseMessage getCommentsByAid(@RequestParam("aid") int aid) {
        return ResponseMessage.newOkInstance(commentService.getCommentsByAid(aid));
    }

    @RequestMapping("/getAllComment")
    public ResponseMessage getAllComment() {
        return ResponseMessage.newOkInstance(commentService.getComments());
    }

    @RequestMapping("/getCommentNumByAid")
    public ResponseMessage getCommentNumByAid(int aid) {
        return ResponseMessage.newOkInstance(commentService.getCommentNumByAid(aid));
    }

    @PostMapping("/addComment")
    public ResponseMessage addComment(@Valid Comment comment, BindingResult bindingResult, HttpServletRequest request) {
        ResponseMessage errors = validate(bindingResult);
        if (errors != null) return errors;
        if (!JWTUtil.verifyId(comment.getUsername(), request)) {
            return ResponseMessage.newErrorInstance("验证错误！请重新登录!");
        }
        int i = commentService.addComment(comment);
        if (i > 0) {
            return ResponseMessage.newOkInstance("评论成功!");
        }
        return ResponseMessage.newErrorInstance("评论失败!");
    }

    @PostMapping("/addReply")
    public ResponseMessage addReply(@Valid Reply reply, BindingResult bindingResult, int targetUserId, HttpServletRequest request) {
        ResponseMessage errors = validate(bindingResult);
        if (errors != null) return errors;
        if (!JWTUtil.verifyId(reply.getUsername(), request)) {
            return ResponseMessage.newErrorInstance("验证错误！请重新登录!");
        }
        int i = commentService.addReply(reply, targetUserId);
        if (i > 0) {
            return ResponseMessage.newOkInstance("回复评论成功!");
        }
        return ResponseMessage.newErrorInstance("回复评论失败!");
    }

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

}
