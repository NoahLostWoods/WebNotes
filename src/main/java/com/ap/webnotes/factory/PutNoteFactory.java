package com.ap.webnotes.factory;

import com.ap.webnotes.command.NoteCommand;
import com.ap.webnotes.dto.NotaDto;
import com.ap.webnotes.model.Nota;
import com.ap.webnotes.utils.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PutNoteFactory {

    @Autowired
    private NoteCommand noteCommand;

    public Nota putNota(NotaDto dto, Integer id) {

        List<Nota> checkNotes = noteCommand.getNotes();

        if(!Utility.checkNotaExisistence(checkNotes, dto)){

            return new Nota()
                    .setId(id)
                    .setTitolo(dto.getTitolo() != null ? dto.getTitolo() : null)
                    .setContenuto(dto.getContenuto() != null ? dto.getContenuto() : null)
                    .setTmsInserimento(retrieveTms(id) != null ? retrieveTms(id) : null)
                    .setTmsUltimoAggiornamento(LocalDateTime.now());
        }else {
            return null;
        }

    }

    protected LocalDateTime retrieveTms(Integer id) {
        Nota singleNote = noteCommand.getSingleNote(id);
        return singleNote.getTmsInserimento();
    }
}
