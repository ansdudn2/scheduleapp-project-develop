package org.example.scheduledevelop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;               // 사용자 ID
    private String username;       // 사용자 이름
    private String email;          // 사용자 이메일
    private String role;           // 사용자 역할 (USER, ADMIN 등)
    private LocalDateTime createdAt; // 생성일
    private LocalDateTime updatedAt; // 수정일

    // 사용자를 생성하는 DTO 생성자
    public UserDto(String username, String email, String role) {
        this.username = username;
        this.email = email;
        this.role = role;
    }
}
