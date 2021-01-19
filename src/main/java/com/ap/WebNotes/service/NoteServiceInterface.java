package com.ap.WebNotes.service;

import com.ap.WebNotes.model.Nota;

import java.util.List;

public interface NoteServiceInterface {
    void saveNota(Nota nota);
    List<Nota> getAll();
}
