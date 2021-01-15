package com.ap.WebNotes.repository;

import com.ap.WebNotes.model.Nota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("noteRepository")
public interface NoteRepositoryInterface extends JpaRepository<Nota, Integer> {
}
