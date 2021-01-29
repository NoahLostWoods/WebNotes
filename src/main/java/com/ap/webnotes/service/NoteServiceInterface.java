package com.ap.webnotes.service;

import com.ap.webnotes.model.Nota;

import java.util.List;
import java.util.Optional;

public interface NoteServiceInterface {
    void saveNota(Nota nota);
    List<Nota> getAll();
    Optional<Nota> findById(Integer id);
    void delete(Integer id);
}
