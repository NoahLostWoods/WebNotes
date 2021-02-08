package com.ap.webnotes.service;

import com.ap.webnotes.model.Nota;

import java.util.List;

public interface NoteServiceInterface {
    void saveNota(Nota nota);

    List<Nota> getAll();

    Nota getOne(Integer id);

    void delete(Integer id);
}
