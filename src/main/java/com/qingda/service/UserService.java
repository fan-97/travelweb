package com.qingda.service;

import com.qingda.dao.UserDao;
import com.qingda.domain.User;

import java.math.BigDecimal;

public class UserService {
    public User login(String name, String passWord) {
        UserDao userDao = new UserDao();
        return userDao.login(name, passWord);
    }

    public void addprice(String userid, BigDecimal price) {
        UserDao userDao = new UserDao();
        userDao.addprice(userid, price.doubleValue());
    }

    public User getuser(String userid) {
        UserDao userDao = new UserDao();
        return userDao.getuserinfo(userid);
    }

    public void edituser(User user) {
        UserDao userDao = new UserDao();
        userDao.edituser(user);
    }

    public void register(User user) {
        UserDao userDao = new UserDao();
        userDao.register(user);
    }

    public User getUserByName(String name){
        UserDao userDao = new UserDao();
        return userDao.getUserInfoByName(name);
    }
}
