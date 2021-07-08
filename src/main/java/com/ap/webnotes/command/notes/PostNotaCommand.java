package com.ap.webnotes.command.notes;

import com.ap.webnotes.dto.notes.NotaDto;
import com.ap.webnotes.model.notes.Nota;
import com.ap.webnotes.service.notes.implementation.NoteServiceImpl;
import com.ap.webnotes.utils.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
public class PostNotaCommand {

    @Autowired
    private NoteServiceImpl noteService;

    public String postNote(Nota nota, NotaDto dto) {
        String message = null;
        List<Nota> note = noteService.getAll();
        try {
            if (!Utility.checkNotaExisistence(note, dto)) {
                noteService.saveNota(nota);
                message = "OK";
            } else {
                message = "Not Okay";
            }
        } catch (Exception e) {
            message = "KO";
        }
        return message;
    }
}
