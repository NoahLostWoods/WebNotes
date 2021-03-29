package com.ap.webnotes.model;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

public class ModelTest {

    @Test
    public void notaTest() {
        Nota nota = new Nota();
        Assert.assertNotNull(nota
                .setId(5)
                .setTitolo("Titolo")
                .setContenuto("Contenuto")
                .setTmsInserimento(LocalDateTime.now())
                .setTmsUltimoAggiornamento(LocalDateTime.now()));
        nota.getId();
        nota.getTitolo();
        nota.getContenuto();
    }

    @Test
    public void idTest() {
        IDs ids = new IDs();
        Assert.assertNotNull(
                ids.setListIds(Collections.singletonList(3))
        );
        ids.getListIds();
    }

    @Test
    public void usersModel() {
        Users users = new Users()
                .setId(5)
                .setPassword("Password")
                .setUser("User")
                .setTmsRegistered(LocalDateTime.now());
        users.getId();
        users.getUser();
        users.getPassword();
        users.getTmsRegistered();
    }
}
