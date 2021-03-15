package com.ap.webnotes.factory;

import com.ap.webnotes.dto.UserDto;
import com.ap.webnotes.model.Users;
import com.ap.webnotes.utils.PasswordEncoderUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PostUserFactory {

    @Autowired
    private PasswordEncoderUtils passwordEncoderUtils;

    public Users dtoToModel(UserDto dto) {
        if (dto != null &&
                !dto.getUser().isEmpty() &&
                !dto.getPasswd().isEmpty()) {
            return new Users()
                    .setUser(dto.getUser())
                    .setPassword(dto.getPasswd())
                    .setTmsRegistered(LocalDateTime.now());
        }
        return null;
    }
}
