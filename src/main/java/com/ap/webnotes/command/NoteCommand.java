package com.ap.webnotes.command;

import com.ap.webnotes.dto.NotaDto;
import com.ap.webnotes.model.IDs;
import com.ap.webnotes.model.Nota;
import com.ap.webnotes.service.implementations.NoteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class NoteCommand {

    @Autowired
    private NoteServiceImpl noteService;

    public List<Nota> getNotes() {
        return noteService.getAll();
    }

    public void postNote(Nota nota) {
        noteService.saveNota(nota);
    }

    public Nota getSingleNote(Integer id) {
        return noteService.getOne(id);
    }

    public void putNote(Nota nota) {
        noteService.saveNota(nota);
    }

    public void deleteSingleNote(Integer id) {
        noteService.delete(id);
    }

    public List<String> deleteMultipleNote(IDs dto) {
        List<String> message = new ArrayList<>();
        for (Integer id : dto.getListIds()) {
            try {
                noteService.delete(id);
                message.add("[" + id + ": OK] ");
            } catch (Exception e) {
                message.add("[" + id + ": KO] ");
            }
        }
        return message;
    }

}
