package com.lanou.user.service.impl;

import com.lanou.commons.CommonUtils;
import com.lanou.user.dao.impl.UserDaoImpl;
import com.lanou.user.domian.User;
import com.lanou.user.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDaoImpl userDao= new UserDaoImpl();

    @Override
    public boolean regist(User user) {
user.setUid(CommonUtils.uuid());
        return userDao.regist(user);
    }

    @Override
    public List<User> login(String username, String password) {
        return userDao.login(username,password);
    }
}
