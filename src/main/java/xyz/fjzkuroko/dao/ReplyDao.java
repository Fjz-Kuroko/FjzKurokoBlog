package xyz.fjzkuroko.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import xyz.fjzkuroko.entity.Reply;
import xyz.fjzkuroko.vo.ChildComment;

import java.util.List;

@Repository
@Mapper
public interface ReplyDao {
    List<ChildComment> getChildCommentsByCid(int cid);
    int getReplyNumByAid(int aid);
    int getMaxReplyId();
    int addReply(Reply reply);
}
