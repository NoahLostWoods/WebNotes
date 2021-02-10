package com.ap.webnotes.assembler;

import com.ap.webnotes.config.BaseTest;
import com.ap.webnotes.model.Nota;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class AssemblerTest extends BaseTest {

    @Test
    public void getNoteAssemblerTest() {

        Nota nota = new Nota()
                .setId(5)
                .setTitolo("Titolo")
                .setContenuto("Contenuto");
        List<Nota> notaList = new ArrayList<>();
        notaList.add(nota);

        Assert.assertNotNull(new GetNoteAssembler().toResource(notaList));
    }

    @Test
    public void getNotaAssemblerTest() {

        Nota nota = new Nota()
                .setId(5)
                .setTitolo("Titolo")
                .setContenuto("Contenuto");

        Assert.assertNotNull(new GetNoteAssembler().toResource(nota));
    }
}
