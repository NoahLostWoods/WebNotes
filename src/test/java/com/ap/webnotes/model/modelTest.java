package com.ap.webnotes.model;

import com.ap.webnotes.config.BaseTest;
import org.junit.Assert;
import org.junit.Test;

public class modelTest extends BaseTest {

    @Test
    public void notaTest() {
        Nota nota = new Nota();
        Assert.assertNotNull(nota
                .setId(5)
                .setTitolo("Titolo")
                .setContenuto("Contenuto"));
        nota.getId();
        nota.getTitolo();
        nota.getContenuto();
    }
}
