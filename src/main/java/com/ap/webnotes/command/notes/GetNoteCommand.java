package com.ap.webnotes.command.notes;

import com.ap.webnotes.dto.notes.NotaDto;
import com.ap.webnotes.model.IDs;
import com.ap.webnotes.model.notes.Nota;
import com.ap.webnotes.service.notes.implementation.NoteServiceImpl;
import com.ap.webnotes.utils.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope("prototype")
public class GetNoteCommand {

    @Autowired
    private NoteServiceImpl noteService;

    public List<Nota> getNotes() {
        return noteService.getAll();
    }

}
