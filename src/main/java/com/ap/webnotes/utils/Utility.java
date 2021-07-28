package com.ap.webnotes.utils;

import com.ap.webnotes.dto.notes.NotaDto;
import com.ap.webnotes.dto.users.UserDto;
import com.ap.webnotes.model.notes.Nota;
import com.ap.webnotes.model.users.Users;

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

        return !checkUser.isEmpty() && checkUser.stream()
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
        return !note.isEmpty() && note.stream()
                .anyMatch(check ->
                        check != null && check.getTitolo() != null && check.getTitolo().contains(noteToInsert.getTitolo()));
    }
}
