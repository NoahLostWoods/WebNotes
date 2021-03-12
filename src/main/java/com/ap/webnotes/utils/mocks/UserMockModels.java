package com.ap.webnotes.utils.mocks;

import com.ap.webnotes.resource.UsersResource;

import java.util.Arrays;
import java.util.List;

public class UserMockModels {

    public static UsersResource getUser() {
        return new UsersResource()
                .setId(1)
                .setUser("User")
                .setPassword("Password");
    }

    public static List<UsersResource> getUsers() {

        return Arrays.asList(getUser());
    }
}
