package com.ap.webnotes.command.notes;

import com.ap.webnotes.model.notes.Nota;
import com.ap.webnotes.service.notes.implementation.NoteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class GetNotaCommand {

    @Autowired
    private NoteServiceImpl noteService;

    public Nota getNota(Integer id, Boolean flag){
        if(id != null && Boolean.TRUE.equals(flag))
            return noteService.getOne(id);

        return new Nota();
    }
}
