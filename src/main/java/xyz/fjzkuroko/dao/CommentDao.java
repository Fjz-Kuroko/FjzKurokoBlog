package xyz.fjzkuroko.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import xyz.fjzkuroko.vo.MyComment;
import xyz.fjzkuroko.entity.Comment;

import java.util.List;

@Repository
@Mapper
public interface CommentDao {
    List<MyComment> getCommentsByAid(int aid);
    List<Comment> getComments();
    int getCommentNumByAid(int aid);
    int getMaxCommentId();
    int addComment(Comment comment);
}
