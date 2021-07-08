package com.ap.webnotes.repository.notes;

import com.ap.webnotes.model.notes.Nota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepositoryInterface extends JpaRepository<Nota, Integer> {
}
