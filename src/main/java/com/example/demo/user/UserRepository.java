package com.example.demo.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository // responsible for data access layer
public interface UserRepository extends JpaRepository<Users, Long> { // Users class and its id (Long)
    @Query("SELECT u FROM Users u WHERE u.email = ?1")
    Optional<Users> findUserByEmail(String email);
}
