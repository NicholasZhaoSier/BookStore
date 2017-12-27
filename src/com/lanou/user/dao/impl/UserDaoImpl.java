package com.lanou.user.dao.impl;

import com.lanou.jdbc.GxQueryRunner;
import com.lanou.user.dao.UserDao;
import com.lanou.user.domian.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private QueryRunner queryRunner = new GxQueryRunner();
    private int flag;

    @Override
    public boolean regist(User user) {
        String sql = "INSERT INTO tb_user VALUES(?,?,?,?,?,?);";
        try {
            flag = queryRunner.update(sql, user.getUid(), user.getUsername(), user.getPassword(),user.getEmail(),user.getCode(),user.isState());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (flag > 0) {
                return true;
            } else {
                return false;
            }
        }

    }

    @Override
    public List<User> login(String username, String password) {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM tb_user WHERE username=? AND password=?;";
        try {
            users =  queryRunner.query(sql,new BeanListHandler<User>(User.class),username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

}
