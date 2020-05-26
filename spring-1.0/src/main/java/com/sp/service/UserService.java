package com.sp.service;

import com.sp.pojo.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    boolean addUser(User user);

    User findUser(int id);
}
