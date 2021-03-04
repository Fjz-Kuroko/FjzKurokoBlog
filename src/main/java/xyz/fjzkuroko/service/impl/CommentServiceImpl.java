package xyz.fjzkuroko.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.fjzkuroko.dao.CommentDao;
import xyz.fjzkuroko.dao.ReplyDao;
import xyz.fjzkuroko.dao.UserDao;
import xyz.fjzkuroko.entity.Reply;
import xyz.fjzkuroko.vo.MyComment;
import xyz.fjzkuroko.entity.Comment;
import xyz.fjzkuroko.service.CommentService;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service("commentService")
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;
    @Autowired
    private ReplyDao replyDao;
    @Autowired
    private UserDao userDao;

    @Override
    public List<MyComment> getCommentsByAid(int aid) {
        return commentDao.getCommentsByAid(aid);
    }

    @Override
    public List<Comment> getComments() {
        return commentDao.getComments();
    }

    @Override
    public int getCommentNumByAid(int aid) {
        return commentDao.getCommentNumByAid(aid) + replyDao.getReplyNumByAid(aid);
    }

    @Override
    public int getNextId() {
        return Integer.max(commentDao.getMaxCommentId(), replyDao.getMaxReplyId()) + 1;
    }

    @Override
    public int addComment(Comment comment) {
        comment.setCid(getNextId());
        comment.setCreateDate(new Timestamp(new Date().getTime()));
        return commentDao.addComment(comment);
    }

    @Override
    public int addReply(Reply reply, int targetUserId) {
        reply.setRid(getNextId());
        reply.setCusername(userDao.getUsernameByUid(targetUserId));
        reply.setCreateDate(new Timestamp(new Date().getTime()));
        return replyDao.addReply(reply);
    }
}
