package com.ap.webnotes.factory;

import com.ap.webnotes.dto.notes.NotaDto;
import com.ap.webnotes.dto.users.UserDto;
import com.ap.webnotes.factory.notes.PostNoteFactory;
import com.ap.webnotes.factory.notes.PutNoteFactory;
import com.ap.webnotes.factory.users.PostUserFactory;
import org.junit.Assert;
import org.junit.Test;

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
        Boolean flg = true;
        Assert.assertNotNull(new PutNoteFactory().putNota(buildNotaDto(), id, flg));
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
