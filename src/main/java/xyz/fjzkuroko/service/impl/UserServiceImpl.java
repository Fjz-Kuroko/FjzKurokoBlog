package xyz.fjzkuroko.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.fjzkuroko.dao.UserDao;
import xyz.fjzkuroko.entity.User;
import xyz.fjzkuroko.service.UserService;
import xyz.fjzkuroko.util.MD5Util;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User login(User user) {
        user.setPassword(MD5Util.getMD5Pwd(user.getPassword(), user.getUsername()));
        return userDao.login(user);
    }

    @Override
    public int register(User user) {
        if (userDao.selectByUsername(user.getUsername()) != null) {
            return -1;
        }
        user.setPassword(MD5Util.getMD5Pwd(user.getPassword(), user.getUsername()));
        return userDao.register(user);
    }

    @Override
    public User selectByUsername(String username) {
        return userDao.selectByUsername(username);
    }
}
