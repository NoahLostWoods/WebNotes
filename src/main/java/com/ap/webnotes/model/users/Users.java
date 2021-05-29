package com.ap.webnotes.model.users;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table
@Entity(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String user;
    private String password;
    private LocalDateTime tmsRegistered;

    public Integer getId() {
        return id;
    }

    public Users setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getUser() {
        return user;
    }

    public Users setUser(String user) {
        this.user = user;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public Users setPassword(String password) {
        this.password = password;
        return this;
    }

    public LocalDateTime getTmsRegistered() {
        return tmsRegistered;
    }

    public Users setTmsRegistered(LocalDateTime tmsRegistered) {
        this.tmsRegistered = tmsRegistered;
        return this;
    }
}
