package com.ap.webnotes.repository;

import com.ap.webnotes.model.Nota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepositoryInterface extends JpaRepository<Nota, Integer> {
}
