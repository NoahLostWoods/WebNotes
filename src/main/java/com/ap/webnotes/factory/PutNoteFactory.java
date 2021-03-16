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
        Nota singleNote = noteCommand.getSingleNote(id);
        LocalDateTime datInserimento = singleNote.getTmsInserimento();
        return dto != null && id != null && datInserimento != null ?
                new Nota()
                        .setId(id)
                        .setTitolo(dto.getTitolo())
                        .setContenuto(dto.getContenuto())
                        .setTmsInserimento(datInserimento)
                        .setTmsUltimoAggiornamento(LocalDateTime.now()) : new Nota();

    }
}
