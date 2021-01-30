package com.ap.webnotes.assembler;

import com.ap.webnotes.model.Nota;
import com.ap.webnotes.resource.NotaResource;
import com.ap.webnotes.resource.pojo.NotaPojo;

import java.util.List;
import java.util.stream.Collectors;

public class GetNoteAssembler {

    public NotaResource toResource(List<Nota> model) {

        return new NotaResource()
                .setListaNoteResource(
                        model.stream()
                                .map(nota -> new NotaPojo()
                                        .setId(nota.getId())
                                        .setTitolo(nota.getTitolo())
                                        .setContenuto(nota.getContenuto()))
                                .collect(Collectors.toList()));
    }
}
