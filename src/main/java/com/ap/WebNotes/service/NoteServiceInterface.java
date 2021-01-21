package com.ap.WebNotes.service;

import com.ap.WebNotes.model.Nota;

import java.util.List;
import java.util.Optional;

public interface NoteServiceInterface {
    void saveNota(Nota nota);
    List<Nota> getAll();
    Optional<Nota> findById(Integer id);
}
