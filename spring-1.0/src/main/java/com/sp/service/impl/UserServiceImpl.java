package com.sp.service.impl;

import com.sp.dao.UserDao;
import com.sp.pojo.User;
import com.sp.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public boolean addUser(User user) {
        if (userDao.addUser(user) > 0)
            return true;
        return false;
    }

    @Override
    public User findUser(int id) {
        return userDao.findUser(id);
    }
}
