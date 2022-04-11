package com.lzqedu.bookCity.dao.impl;

import com.atguigu.myssm.basedao.BaseDAO;
import com.lzqedu.bookCity.dao.UserDAO;
import com.lzqedu.bookCity.pojo.User;

public class UserDAOImpl extends BaseDAO<User> implements UserDAO {
    @Override
    public User getUser(String uname, String pwd) {
        return load("select * from t_user where uname like ? and pwd like ?",uname,pwd);
    }

    @Override
    public void addUser(User user) {
        executeUpdate("insert into t_user values(null,?,?,?,?)",user.getUname(),user.getPwd(),user.getEmail(),user.getRole());
    }
}
