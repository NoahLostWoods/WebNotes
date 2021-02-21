package com.ap.webnotes.dto;

public class UserDto {

    private String user;
    private String passwd;

    public String getUser() {
        return user;
    }

    public UserDto setUser(String user) {
        this.user = user;
        return this;
    }

    public String getPasswd() {
        return passwd;
    }

    public UserDto setPasswd(String passwd) {
        this.passwd = passwd;
        return this;
    }
}
