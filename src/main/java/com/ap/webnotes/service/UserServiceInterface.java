package com.ap.webnotes.service;

import com.ap.webnotes.model.Users;

import java.util.List;

public interface UserServiceInterface {

    void saveUser(Users users);

    List<Users> getAllUsers();

    Users findById(Integer id);

    void deleteUser(Integer id);
}
