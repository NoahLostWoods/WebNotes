package com.ap.webnotes.assembler.users;

import com.ap.webnotes.model.users.Users;
import com.ap.webnotes.resource.users.UsersResource;

public class GetUserAssembler {

    public UsersResource toResource(Users model) {

        return model != null ? new UsersResource()
                .setId(model.getId())
                .setUser(model.getUser())
                .setPassword(model.getPassword())
                .setTmsRegistered(model.getTmsRegistered()) : new UsersResource();
    }
}
