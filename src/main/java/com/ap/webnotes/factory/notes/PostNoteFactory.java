package com.ap.webnotes.factory.notes;

import com.ap.webnotes.dto.notes.NotaDto;
import com.ap.webnotes.model.notes.Nota;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PostNoteFactory {

    public Nota postNota(NotaDto dto) {
        return dto != null &&
                dto.getTitolo() != null &&
                dto.getContenuto() != null ?
                new Nota()
                        .setId(dto.getId())
                        .setTitolo(dto.getTitolo())
                        .setContenuto(dto.getContenuto())
                        .setTmsInserimento(LocalDateTime.now()) : new Nota();

    }
}
