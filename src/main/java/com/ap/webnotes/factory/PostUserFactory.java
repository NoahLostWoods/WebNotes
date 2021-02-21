package com.ap.webnotes.factory;

import com.ap.webnotes.dto.UserDto;
import com.ap.webnotes.model.Users;
import org.springframework.stereotype.Service;

@Service
public class PostUserFactory {

    public Users dtoToModel(UserDto dto) {
        if (dto != null &&
                !dto.getUser().isEmpty() &&
                !dto.getPasswd().isEmpty()) {
            return new Users()
                    .setUser(dto.getUser())
                    .setPassword(dto.getPasswd());
        }
        return null;
    }
}
