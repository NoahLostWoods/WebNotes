package com.ap.webnotes.resource;

import com.ap.webnotes.resource.pojo.NotaPojo;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Arrays;

public class ResourceTest {

    @Test
    public void getNotaResource() {

        NotaResource notaResource = new NotaResource()
                .setListaNoteResource(Arrays.asList(buidNotaPojo()));

        notaResource.getListaNoteResource();
    }

    @Test
    public void getNotaPojo() {
        NotaPojo notaPojo = buidNotaPojo();

        notaPojo.getId();
        notaPojo.getTitolo();
        notaPojo.getContenuto();
        notaPojo.getTmsInserimento();
        notaPojo.getTmsUltimoAggiornamento();
    }

    @Test
    public void getUsers() {
        UsersResource usersResource = buildUsersResource();

        usersResource.getId();
        usersResource.getUser();
        usersResource.getPassword();
        usersResource.getTmsRegistered();
    }

    //Settings method

    private NotaPojo buidNotaPojo() {
        return new NotaPojo()
                .setId(5)
                .setTitolo("Title")
                .setContenuto("Content")
                .setTmsInserimento(LocalDateTime.now())
                .setTmsUltimoAggiornamento(LocalDateTime.now());
    }

    private UsersResource buildUsersResource() {
        return new UsersResource()
                .setId(5)
                .setUser("User")
                .setPassword("Password")
                .setTmsRegistered(LocalDateTime.now());

    }


}
