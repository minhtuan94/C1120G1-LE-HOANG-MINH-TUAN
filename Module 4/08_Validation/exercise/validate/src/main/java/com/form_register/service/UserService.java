package com.form_register.service;

import com.form_register.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User findById(Integer id);

    void save(User user);

    void delete(Integer id);
}
