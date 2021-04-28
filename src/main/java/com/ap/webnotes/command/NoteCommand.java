package com.ap.webnotes.command;

import com.ap.webnotes.dto.NotaDto;
import com.ap.webnotes.model.IDs;
import com.ap.webnotes.model.Nota;
import com.ap.webnotes.service.implementations.NoteServiceImpl;
import com.ap.webnotes.utils.Utility;
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

    public String postNote(Nota nota, NotaDto dto) {
        String message = null;
        List<Nota> note = getNotes();
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

    public Nota getSingleNote(Integer id, Boolean flg) {
        if (id != null && flg.equals(Boolean.TRUE)) {
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
