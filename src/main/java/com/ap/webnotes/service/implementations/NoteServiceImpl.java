package com.ap.webnotes.service.implementations;

import com.ap.webnotes.model.Nota;
import com.ap.webnotes.repository.NoteRepositoryInterface;
import com.ap.webnotes.service.NoteServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
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
    public Optional<Nota> findById(Integer id) {
        return noteRepos.findById(id);
    }

    @Override
    public void delete(Integer id) {
        noteRepos.deleteById(id);
    }

}
