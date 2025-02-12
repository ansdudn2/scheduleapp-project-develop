package org.example.scheduledevelop.repository;

import org.example.scheduledevelop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository를 사용하여 User 엔티티에 대한 CRUD 기능을 제공
public interface UserRepository extends JpaRepository<User, Long> {
    // 사용자 이름으로 사용자 조회
    User findByUsername(String username);

    // 이메일로 사용자 조회
    User findByEmail(String email);
}


