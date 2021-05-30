package com.ap.webnotes.command.businesslogic.notes;

import com.ap.webnotes.command.notes.GetNotaCommand;
import com.ap.webnotes.command.notes.GetNoteCommand;
import com.ap.webnotes.model.notes.Nota;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PutNoteBusinessLogic {

    @Autowired
    private GetNoteCommand noteCommand;
    @Autowired
    private GetNotaCommand getNotaCommand;

    public LocalDateTime retrieveData(Integer id, Boolean flg) {
        if(id != null) {
            return getNotaCommand.getNota(id, flg).getTmsInserimento();
        }else {
            return null;
        }
    }

    public List<Nota> retrieveNotes() {
        return noteCommand.getNotes();
    }
}
