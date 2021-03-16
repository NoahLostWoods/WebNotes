package com.ap.webnotes.utils;

import com.ap.webnotes.dto.NotaDto;
import com.ap.webnotes.dto.UserDto;
import com.ap.webnotes.model.Nota;
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
    public static boolean checkUserExsistence(List<Users> checkUser, UserDto usersToInsert) {

        return checkUser != null && checkUser.stream()
                .allMatch(check -> check.getUser().contains(usersToInsert.getUser()));
    }


    /**
     * method that allow to verify if a note is already exist or none
     *
     * @param note         list of notes from external source
     * @param noteToInsert note insert from dto
     * @return true if note exist or false if note not exist
     */
    public static boolean checkNotaExisistence(List<Nota> note, NotaDto noteToInsert) {
        return note != null && note.stream()
                .allMatch(check -> check.getTitolo().contains(noteToInsert.getTitolo()));
    }
}
