package com.ap.webnotes.factory;

import com.ap.webnotes.dto.NotaDto;
import com.ap.webnotes.model.Nota;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service

public class PutNoteFactory {

    public Nota putNota(NotaDto dto, Integer id, LocalDateTime datInserimento) {
        return new Nota()
                .setId(id)
                .setTitolo(dto.getTitolo())
                .setContenuto(dto.getContenuto())
                .setTmsInserimento(datInserimento)
                .setTmsUltimoAggiornamento(LocalDateTime.now());

    }
}
