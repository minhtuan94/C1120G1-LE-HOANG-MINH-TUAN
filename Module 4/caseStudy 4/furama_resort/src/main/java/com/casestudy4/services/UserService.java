package com.casestudy4.services;


import com.casestudy4.entity.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);

}