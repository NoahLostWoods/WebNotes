package com.ap.webnotes.command.notes;

import com.ap.webnotes.service.notes.implementation.NoteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class DeleteNotaCommand {

    @Autowired
    private NoteServiceImpl noteService;

    public String deleteNota(Integer id){
        String message = null;
        try{
            noteService.delete(id);
            message = "OK";
        }catch (Exception e){
            message = "KO";
        }
        return message;
    }
}
