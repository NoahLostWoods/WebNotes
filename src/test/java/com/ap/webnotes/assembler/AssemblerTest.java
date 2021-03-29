package com.ap.webnotes.assembler;

import com.ap.webnotes.model.Nota;
import com.ap.webnotes.model.Users;
import org.junit.Assert;
import org.junit.Test;

import javax.jws.soap.SOAPBinding;
import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class AssemblerTest {

    @Test
    public void getNoteAssemblerTest() {
        Assert.assertNotNull(new GetNoteAssembler().toResource(buildListaNote()));
    }

    @Test
    public void getNotaAssemblerTest() {
        Assert.assertNotNull(new GetNoteAssembler().toResource(buildNota()));
    }

    @Test
    public void getUsersAssemblerTest() {
        Assert.assertNotNull(new GetUsersAssembler().toResource(buildUsers()));
        Assert.assertNotNull(new GetUsersAssembler().toResource(null));
    }

    @Test
    public void getUserAssemblerTest() {
        Assert.assertNotNull(new GetUserAssembler().toResource(buildUser()));
    }

    //Settings method

    private List<Users> buildUsers() {
        return Arrays.asList(buildUser());
    }

    private List<Nota> buildListaNote() {
        return Arrays.asList(buildNota());
    }

    private Nota buildNota() {
        return new Nota()
                .setId(5)
                .setTitolo("Titolo")
                .setContenuto("Contenuto")
                .setTmsInserimento(LocalDateTime.now())
                .setTmsUltimoAggiornamento(LocalDateTime.now());
    }

    private Users buildUser() {
        return new Users()
                .setId(5)
                .setUser("Users")
                .setPassword("Password")
                .setTmsRegistered(LocalDateTime.now());
    }
}
