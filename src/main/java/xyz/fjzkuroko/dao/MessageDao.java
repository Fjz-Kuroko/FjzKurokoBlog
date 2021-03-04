package xyz.fjzkuroko.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import xyz.fjzkuroko.entity.Message;

@Repository
@Mapper
public interface MessageDao {
    int addMessage(Message message);
}
