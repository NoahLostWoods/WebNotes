package com.ap.webnotes.utils.mocks;

import com.ap.webnotes.model.Nota;
import com.ap.webnotes.resource.NotaResource;
import com.ap.webnotes.resource.pojo.NotaPojo;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;

public class NoteMocks {

    public static ResponseEntity<NotaResource> getNotesMocks() {
        Nota notaModel = new Nota()
                .setId(1)
                .setTitolo("Title")
                .setContenuto("Content");

        return ResponseEntity.ok(new NotaResource()
                .setListaNoteResource(Arrays.asList(new NotaPojo()
                        .setId(notaModel.getId())
                        .setTitolo(notaModel.getTitolo())
                        .setContenuto(notaModel.getContenuto())
                )));
    }
}
