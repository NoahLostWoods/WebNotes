package com.ap.webnotes.factory;

import com.ap.webnotes.dto.NotaDto;
import com.ap.webnotes.model.Nota;

public class PutNoteFactory {

    public Nota putNota(NotaDto dto) {
        return new Nota()
                .setId(dto.getId())
                .setTitolo(dto.getTitolo())
                .setContenuto(dto.getContenuto());

    }
}
