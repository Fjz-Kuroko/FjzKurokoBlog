package xyz.fjzkuroko.service;

import xyz.fjzkuroko.entity.User;

public interface UserService {
    User login(User user);
    int register(User user);
    User selectByUsername(String username);
}
