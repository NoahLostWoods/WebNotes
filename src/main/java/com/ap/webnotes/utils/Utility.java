package com.ap.webnotes.utils;

import com.ap.webnotes.model.Users;

import java.util.List;

public class Utility {

    /**
     * method that allow to verify if an user exist or none
     *
     * @param checkUser     user from external source
     * @param usersToInsert user insert from dto
     * @return true if user exist or false if user not exist
     */
    public static boolean checkUserExsistence(List<Users> checkUser, Users usersToInsert) {

        return checkUser != null && checkUser.stream()
                .anyMatch(check -> check.getUser().contains(usersToInsert.getUser()));
    }
}
