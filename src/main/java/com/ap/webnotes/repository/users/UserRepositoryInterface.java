package com.ap.webnotes.repository.users;

import com.ap.webnotes.model.users.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositoryInterface extends JpaRepository<Users, Integer> {
}
