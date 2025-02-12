package org.example.scheduledevelop.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.example.scheduledevelop.dto.LoginRequestDto;
import org.example.scheduledevelop.entity.User;
import org.example.scheduledevelop.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final UserRepository userRepository;

    public ResponseEntity<String> login(LoginRequestDto loginRequestDto, HttpServletRequest request) {
        // 이메일로 사용자 검색
        Optional<User> optionalUser = userRepository.findByEmail(loginRequestDto.getEmail());

        if (optionalUser.isEmpty()) {
            // 이메일이 일치하지 않는 경우
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
        }

        User user = optionalUser.get();

        // 비밀번호가 일치하지 않는 경우
        if (!user.getPassword().equals(loginRequestDto.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
        }

        // 로그인 성공 시 세션에 사용자 이메일 저장
        HttpSession session = request.getSession(true);  // 세션 없으면 새로 생성
        session.setAttribute("userEmail", user.getEmail());

        return ResponseEntity.ok("Login successful");
    }

    // 로그아웃 기능 (세션 삭제)
    public ResponseEntity<String> logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false); // false로 하면 세션이 없으면 새로 생성되지 않음
        if (session != null) {
            session.invalidate();  // 세션 삭제
        }
        return ResponseEntity.ok("Logout successful");
    }
}


