package com.ap.webnotes.factory;

import com.ap.webnotes.dto.NotaDto;
import com.ap.webnotes.dto.UserDto;
import com.ap.webnotes.model.Nota;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class FactoryTest {

    @Test
    public void postNoteFactoryTest() {

        Assert.assertNotNull(new PostNoteFactory().postNota(buildNotaDto()));
    }

    @Test
    public void postUserFactoryTest() {
        Assert.assertNotNull(new PostUserFactory().dtoToModel(buildUserDto()));
    }

    @Test
    public void putNoteFactory() {
        Integer id = 5;
        Assert.assertNotNull(new PutNoteFactory().putNota(buildNotaDto(), id));
    }


    //Settings method
    private NotaDto buildNotaDto() {
        return new NotaDto()
                .setId(5)
                .setTitolo("Title")
                .setContenuto("Content");
    }

    private UserDto buildUserDto() {
        return new UserDto()
                .setUser("User")
                .setPasswd("Password");
    }
}
