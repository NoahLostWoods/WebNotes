package com.ap.webnotes.command.users;

import com.ap.webnotes.model.users.Users;
import com.ap.webnotes.service.users.implementation.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class UserCommand {

    @Autowired
    private UserServiceImpl userService;

    public List<Users> getUsers() {
        try {
            return userService.getAllUsers();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    public void postUser(Users user) {
        try {
            userService.saveUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Users getUser(Integer id) {
        try {
            return userService.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
