package com.ap.webnotes.repository;

import com.ap.webnotes.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositoryInterface extends JpaRepository<Users, Integer> {
}
