package org.example.scheduledevelop.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.example.scheduledevelop.dto.LoginRequestDto;
import org.example.scheduledevelop.service.LoginService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final LoginService loginService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDto loginRequest, HttpServletRequest request) {
        // 로그인 서비스에 HttpServletRequest를 전달
        return loginService.login(loginRequest, request);  // HttpServletRequest를 전달하여 로그인 처리
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpServletRequest request) {
        // 세션 삭제 처리
        return loginService.logout(request);
    }
}
