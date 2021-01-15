package com.ap.WebNotes.service.implementations;

import com.ap.WebNotes.model.Nota;
import com.ap.WebNotes.repository.NoteRepositoryInterface;
import com.ap.WebNotes.service.NoteServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("noteService")
public class NoteServiceImpl implements NoteServiceInterface {

    @Autowired
    private NoteRepositoryInterface noteRepos;

    @Override
    public void saveNota(Nota nota) {
        noteRepos.save(nota);

    }

    @Override
    public List<Nota> getAll() {
        return noteRepos.findAll();
    }

    @Override
    public void delete(Nota nota) {
        noteRepos.delete(nota);
    }
}
