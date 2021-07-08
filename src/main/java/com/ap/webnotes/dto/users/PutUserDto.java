package com.ap.webnotes.dto.users;

import java.time.LocalDateTime;

public class PutUserDto {

    private String user;
    private LocalDateTime tmsLastUpdate;

    public String getUser() {
        return user;
    }

    public PutUserDto setUser(String user) {
        this.user = user;
        return this;
    }

    public LocalDateTime getTmsLastUpdate() {
        return tmsLastUpdate;
    }

    public PutUserDto setTmsLastUpdate(LocalDateTime tmsLastUpdate) {
        this.tmsLastUpdate = tmsLastUpdate;
        return this;
    }
}
