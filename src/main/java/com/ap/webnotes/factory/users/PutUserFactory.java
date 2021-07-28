package com.ap.webnotes.factory.users;

import com.ap.webnotes.dto.users.PutUserDto;
import com.ap.webnotes.model.users.Users;
import org.springframework.stereotype.Service;

@Service
public class PutUserFactory {

    public Users dtoToModel(PutUserDto putUserDto, Integer id){
        return new Users()
                .setId(id)
                .setUser(putUserDto.getUser())
                .setTmsLastRegistered(putUserDto.getTmsLastUpdate());
    }
}
