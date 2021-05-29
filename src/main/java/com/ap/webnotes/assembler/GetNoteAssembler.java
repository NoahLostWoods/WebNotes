package com.ap.webnotes.assembler;

import com.ap.webnotes.model.Nota;
import com.ap.webnotes.resource.NotaResource;
import com.ap.webnotes.resource.pojo.NotaPojo;

import java.util.*;
import java.util.stream.Collectors;

public class GetNoteAssembler {

    public NotaResource toResource(List<Nota> model) {
        return new NotaResource()
                .setListaNoteResource(model
                        .stream()
                        .map(nota -> new NotaPojo()
                                .setId(nota.getId() != null ? nota.getId() : null)
                                .setTitolo(nota.getTitolo() != null ? nota.getTitolo() : null)
                                .setContenuto(nota.getContenuto() != null ? nota.getContenuto() : null)
                                .setTmsInserimento(nota.getTmsInserimento() != null ? nota.getTmsInserimento() : null)
                                .setTmsUltimoAggiornamento(nota.getTmsUltimoAggiornamento() != null ? nota.getTmsUltimoAggiornamento() : null))
                        .collect(Collectors.toList()));
    }
}
