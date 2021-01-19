package com.ap.WebNotes.service;

import com.ap.WebNotes.model.Nota;

import java.util.List;

public interface NoteServiceInterface {
    void saveNota(Nota nota);
    void update(Nota nota);
    List<Nota> getAll();
    Nota findById(Integer notaId);
}
