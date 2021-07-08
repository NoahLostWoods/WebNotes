package com.ap.webnotes.service.notes;

import com.ap.webnotes.model.notes.Nota;

import java.util.List;

public interface NoteServiceInterface {
    void saveNota(Nota nota);

    List<Nota> getAll();

    Nota getOne(Integer id);

    void delete(Integer id);
}
