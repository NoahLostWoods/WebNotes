package com.ap.webnotes.resource;

public class UsersResource {

    private Integer id;
    private String user;
    private String password;

    public Integer getId() {
        return id;
    }

    public UsersResource setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getUser() {
        return user;
    }

    public UsersResource setUser(String user) {
        this.user = user;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UsersResource setPassword(String password) {
        this.password = password;
        return this;
    }
}
