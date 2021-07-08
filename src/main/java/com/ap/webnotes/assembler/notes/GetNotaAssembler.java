package com.ap.webnotes.assembler.notes;

import com.ap.webnotes.model.notes.Nota;
import com.ap.webnotes.resource.notes.NotaResource;
import com.ap.webnotes.resource.notes.pojo.NotaPojo;

import java.util.Collections;

public class GetNotaAssembler {

    public NotaResource toResource(Nota model) {
        return new NotaResource()
                .setListaNoteResource(
                        Collections.singletonList(
                                new NotaPojo()
                                        .setId(model.getId() != null ? model.getId() : null)
                                        .setTitolo(model.getTitolo() != null ? model.getTitolo() : null)
                                        .setContenuto(model.getContenuto() != null ? model.getContenuto() : null)
                                        .setTmsInserimento(model.getTmsInserimento() != null ? model.getTmsInserimento() : null)
                                        .setTmsUltimoAggiornamento(model.getTmsUltimoAggiornamento() != null ? model.getTmsUltimoAggiornamento() : null)
                        ));
    }

}
