package com.ap.webnotes.resource.users;

import java.time.LocalDateTime;

public class UsersResource {

    private Integer id;
    private String user;
    private String password;
    private LocalDateTime tmsRegistered;

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

    public LocalDateTime getTmsRegistered() {
        return tmsRegistered;
    }

    public UsersResource setTmsRegistered(LocalDateTime tmsRegistered) {
        this.tmsRegistered = tmsRegistered;
        return this;
    }
}
