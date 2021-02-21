package com.ap.webnotes.service.implementations;

import com.ap.webnotes.model.Users;
import com.ap.webnotes.repository.UserRepositoryInterface;
import com.ap.webnotes.service.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserServiceInterface {

    @Autowired
    private UserRepositoryInterface userRepositoryInterface;

    @Override
    public void saveUser(Users users) {
        userRepositoryInterface.save(users);
    }

    @Override
    public List<Users> getAllUsers() {
        return userRepositoryInterface.findAll();
    }

    @Override
    public Users findById(Integer id) {
        return userRepositoryInterface.getOne(id);
    }

    @Override
    public void deleteUser(Integer id) {
        userRepositoryInterface.deleteById(id);
    }
}
