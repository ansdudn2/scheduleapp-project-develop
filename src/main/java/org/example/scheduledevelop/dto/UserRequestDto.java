package org.example.scheduledevelop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDto {
    private String username;  // 사용자 이름
    private String email;     // 사용자 이메일
    private String password;  // 사용자 비밀번호
    private String role;      // 사용자 역할 (USER, ADMIN 등)
}
