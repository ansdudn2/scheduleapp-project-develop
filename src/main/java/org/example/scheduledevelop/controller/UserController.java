package org.example.scheduledevelop.controller;

import org.example.scheduledevelop.dto.UserDto;
import org.example.scheduledevelop.dto.UserRequestDto;
import org.example.scheduledevelop.dto.UserResponseDto;
import org.example.scheduledevelop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")  // 사용자 관련 API 경로
public class UserController {

    @Autowired
    private UserService userService;  // UserService를 자동 주입

    // 사용자 생성 (POST)
    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserRequestDto userRequestDto) {
        // 서비스 메서드 호출하여 사용자 생성
        UserDto createdUser = userService.createUser(userRequestDto);
        // 생성된 사용자 정보와 상태 코드(201 Created) 반환
        return ResponseEntity.status(201).body(createdUser);
    }

    // 전체 유저 조회
    @GetMapping
    public ResponseEntity<List<UserResponseDto>> getAllUsers() {
        List<UserResponseDto> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    // 사용자 조회 (단건, GET)
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
        // 서비스 메서드로 사용자 조회
        UserDto userDto = userService.getUserById(id);
        // 사용자 존재하면 200 OK 반환, 없으면 404 Not Found 반환
        return userDto != null ? ResponseEntity.ok(userDto) : ResponseEntity.notFound().build();
    }

    // 사용자 수정 (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable Long id, @RequestBody UserRequestDto userRequestDto) {
        // 서비스 메서드로 사용자 수정
        UserDto updatedUser = userService.updateUser(id, userRequestDto);
        // 수정된 사용자 정보 반환
        return updatedUser != null ? ResponseEntity.ok(updatedUser) : ResponseEntity.notFound().build();
    }

    // 사용자 삭제 (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        // 서비스 메서드로 사용자 삭제
        userService.deleteUser(id);
        // 삭제 후 상태 코드(204 No Content) 반환
        return ResponseEntity.noContent().build();
    }
}
