package com.example.webapp.repository;

import com.example.webapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);

    @Query("SELECT u FROM User u WHERE u.id > :id")
    List<User> findAllByIdAfter(@Param("id") int id);
}

