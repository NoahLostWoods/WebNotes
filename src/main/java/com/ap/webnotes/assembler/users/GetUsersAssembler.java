package com.ap.webnotes.assembler.users;

import com.ap.webnotes.model.users.Users;
import com.ap.webnotes.resource.users.UsersResource;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class GetUsersAssembler {

    public List<UsersResource> toResource(List<Users> users) {

        return users != null ? users.stream().map(user -> new UsersResource()
                .setId(user.getId())
                .setUser(user.getUser())
                .setPassword(user.getPassword())
                .setTmsRegistered(user.getTmsRegistered()))
                .collect(Collectors.toList())
                : Collections.emptyList();


    }
}
