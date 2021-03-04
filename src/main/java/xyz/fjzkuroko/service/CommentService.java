package xyz.fjzkuroko.service;

import xyz.fjzkuroko.entity.Reply;
import xyz.fjzkuroko.vo.MyComment;
import xyz.fjzkuroko.entity.Comment;

import java.util.List;

public interface CommentService {
    List<MyComment> getCommentsByAid(int aid);
    List<Comment> getComments();
    int getCommentNumByAid(int aid);
    int getNextId();
    int addComment(Comment comment);
    int addReply(Reply reply, int targetUserId);
}
