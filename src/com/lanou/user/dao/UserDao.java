package com.lanou.user.dao;

import com.lanou.user.domian.User;

import java.util.List;

public interface UserDao {
    boolean regist(User user);
    List<User> login (String username, String password);
}
