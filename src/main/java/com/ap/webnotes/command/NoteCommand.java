package com.ap.webnotes.command;

import com.ap.webnotes.controller.WebNotesController;
import com.ap.webnotes.dto.NotaDto;
import com.ap.webnotes.model.IDs;
import com.ap.webnotes.model.Nota;
import com.ap.webnotes.service.implementations.NoteServiceImpl;
import org.aspectj.weaver.ast.Not;
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

    public String postNote(Nota nota, List<Nota> checkNotes, NotaDto dto) {
        String message;
        try {
            if (!WebNotesController.checkNotaExisistence(checkNotes, dto)) {
                noteService.saveNota(nota);
            }
            message = "OK";
        } catch (Exception e) {
            message = "KO";
        }
        return message;
    }

    public Nota getSingleNote(Integer id) {
        if (id != null) {
            return noteService.getOne(id);
        } else {
            return new Nota();
        }
    }

    public String putNote(Nota nota) {
        String message = null;
        try {
            noteService.saveNota(nota);
            message = "OK";
        } catch (Exception e) {
            message = "KO";
        }
        return message;
    }

    public String deleteSingleNote(Integer id) {
        String message = null;
        try {
            noteService.delete(id);
            message = "OK";
        } catch (Exception e) {
            message = "KO";
        }
        return message;
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
