package com.lanou.user.service;

import com.lanou.user.domian.User;

import java.util.List;

public interface UserService {
    boolean regist(User user);
    List<User> login(String username, String password);
}
