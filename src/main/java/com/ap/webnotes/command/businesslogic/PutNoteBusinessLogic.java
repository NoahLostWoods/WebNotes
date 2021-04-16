package com.ap.webnotes.command.businesslogic;

import com.ap.webnotes.command.NoteCommand;
import com.ap.webnotes.model.Nota;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PutNoteBusinessLogic {

    @Autowired
    private NoteCommand noteCommand;

    public LocalDateTime retrieveData(Integer id, Boolean flg) {
        if(id != null) {
            return noteCommand.getSingleNote(id, flg).getTmsInserimento();
        }else {
            return null;
        }
    }

    public List<Nota> retrieveNotes() {
        return noteCommand.getNotes();
    }
}
