package com.ap.webnotes.command.notes;

import com.ap.webnotes.model.IDs;
import com.ap.webnotes.service.notes.implementation.NoteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope("prototype")
public class DeleteNoteCommand {

    @Autowired
    private NoteServiceImpl noteService;

    public List<String> deleteNotes(IDs ids){
        List<String> message = new ArrayList<>();
        for(Integer id : ids.getListIds()){
            try{
                noteService.delete(id);
                message.add("[" + id + ": OK] ");
            }catch (Exception e){
                message.add("[" + id + ": KO]" );
            }
        }
        return message;
    }
}
