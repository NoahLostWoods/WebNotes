package com.ap.webnotes.factory;

import com.ap.webnotes.command.NoteCommand;
import com.ap.webnotes.dto.NotaDto;
import com.ap.webnotes.model.Nota;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PutNoteFactory {

    @Autowired
    private NoteCommand noteCommand;

    public Nota putNota(NotaDto dto, Integer id) {

        return
                new Nota()
                        .setId(id)
                        .setTitolo(dto.getTitolo() != null ? dto.getTitolo() : null)
                        .setContenuto(dto.getContenuto() != null ? dto.getContenuto() : null)
                        .setTmsInserimento(retrieveTms(id) != null ? retrieveTms(id) : null)
                        .setTmsUltimoAggiornamento(LocalDateTime.now());

    }

    protected LocalDateTime retrieveTms(Integer id) {
        Nota singleNote = noteCommand.getSingleNote(id);
        return singleNote.getTmsInserimento();
    }
}
