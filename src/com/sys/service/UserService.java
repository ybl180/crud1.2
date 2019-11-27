package com.sys.service;

import com.sys.dao.UserDao;
import com.sys.entity.PageBean;
import com.sys.entity.User;

import java.util.List;

/**
 * @author ybl
 * @version 1.0.1
 * @conpany 东风标准
 * @date 2019/11/26 17:38
 * @desciption
 */
public class UserService {
    private UserDao userDao = new UserDao();

    public List<User> findAll(String account, PageBean pageBean) {
        return userDao.findAll(account,pageBean);
    }

    public Integer count(String account) {
        return userDao.count(account);
    }

    public void deleteUser(Integer id) {
        userDao.deleteUser(id);
    }

    public void addUser(User user) {
        userDao.addUser(user);
    }

    public User getUserById(Integer id) {
        return userDao.getUserById(id);
    }

    public void updateUser(User user) {
        userDao.updateUser(user);
    }
}
