package com.ap.webnotes.command.notes;

import com.ap.webnotes.model.notes.Nota;
import com.ap.webnotes.service.notes.implementation.NoteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
public class PutNoteCommand {

    @Autowired
    private NoteServiceImpl noteService;

    // TODO Genere oggetto null se nel dto della modifica passo lo stesso titolo e contenuto già esistente per quel id.
    public String putNota(Nota nota){
        List<Nota> note = noteService.getAll();

        String message = null;
        try {
            noteService.saveNota(nota);
            message = "OK";
        }catch (Exception e){
            message = "KO";
        }
        return message;
    }
}
