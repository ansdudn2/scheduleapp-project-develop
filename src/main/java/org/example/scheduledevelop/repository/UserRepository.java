package org.example.scheduledevelop.repository;

import org.example.scheduledevelop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    Optional<User> findByEmail(String email); // Optional<User>로 변경
}


