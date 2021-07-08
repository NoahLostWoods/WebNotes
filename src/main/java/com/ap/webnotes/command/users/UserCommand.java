package com.ap.webnotes.command.users;

import com.ap.webnotes.model.users.Users;
import com.ap.webnotes.service.users.implementation.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import utils.ListUtils;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;

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

    public Users getUserByName(String name){
        ListUtils utils = new ListUtils();
        List<Users> users = getUsers();
        if(utils.isNotEmpty(users)){
            for (Users us : users){
                if(us.getUser() != null && us.getUser().equals(name)){
                    return new Users()
                            .setId(us.getId())
                            .setUser(us.getUser())
                            .setPassword("N/A")
                            .setTmsRegistered(us.getTmsRegistered());
                }
            }
        }
        return new Users();
    }

    public String deleteById(Integer id) {
        Boolean flg = false;
        try {
            userService.deleteUser(id);
            flg = true;
        }catch (Exception e){
            flg = false;
        }
        if (flg) {
            return "OK";
        }else {
            return "KO";
        }
    }

    public String putUser(Users users){
        Boolean flg = false;
        try{
            List<Users> checkUsers = userService.getAllUsers();
            Boolean match = checkUsers.stream().allMatch(a -> a.getUser().equals(users.getUser()));
            if (match){
                flg = false;
            }else{
                userService.saveUser(users);
                flg = true;
            }
        }catch (Exception e){
            flg = false;
        }

        if(flg){
            return "OK";
        }else {
            return "KO";
        }
    }
}
