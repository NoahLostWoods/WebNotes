package com.ap.webnotes.assembler;

import com.ap.webnotes.model.Nota;
import com.ap.webnotes.resource.NotaResource;
import com.ap.webnotes.resource.pojo.NotaPojo;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
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

    public NotaResource toResource(Optional<Nota> model) {

        return new NotaResource()
                .setListaNoteResource(Arrays.asList(new NotaPojo()
                        .setId(model.map(Nota::getId).orElse(null))
                        .setTitolo(model.map(Nota::getTitolo).orElse(null))
                        .setContenuto(model.map(Nota::getContenuto).orElse(null))));
    }
}
