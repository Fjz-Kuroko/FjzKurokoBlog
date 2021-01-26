package xyz.fjzkuroko.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import xyz.fjzkuroko.entity.User;

@Mapper
@Repository
public interface UserDao {
    User login(User user);
    int register(User user);
    User selectByUsername(String username);
}
