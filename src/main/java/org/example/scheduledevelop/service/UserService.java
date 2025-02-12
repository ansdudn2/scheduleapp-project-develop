package org.example.scheduledevelop.service;

import org.example.scheduledevelop.dto.UserDto;
import org.example.scheduledevelop.dto.UserRequestDto;
import org.example.scheduledevelop.entity.User;
import org.example.scheduledevelop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // 사용자 생성
    public UserDto createUser(UserRequestDto userRequestDto) {
        // DTO -> 엔티티 변환 후 저장
        User user = new User(userRequestDto.getUsername(), userRequestDto.getEmail(), userRequestDto.getPassword(), userRequestDto.getRole());
        userRepository.save(user);

        // 엔티티에서 DTO로 변환하여 반환
        return new UserDto(user.getId(), user.getUsername(), user.getEmail(), user.getRole(), user.getCreatedAt(), user.getUpdatedAt());
    }

    // 사용자 조회
    public UserDto getUserById(Long id) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null) {
            return null;
        }
        // 비밀번호 제외한 DTO 반환
        return new UserDto(user.getId(), user.getUsername(), user.getEmail(), user.getRole(), user.getCreatedAt(), user.getUpdatedAt());
    }

    // 사용자 수정
    public UserDto updateUser(Long id, UserRequestDto userRequestDto) {
        User existingUser = userRepository.findById(id).orElse(null);
        if (existingUser == null) {
            return null;
        }

        // 수정할 부분만 업데이트
        existingUser.setUsername(userRequestDto.getUsername());
        existingUser.setEmail(userRequestDto.getEmail());
        existingUser.setRole(userRequestDto.getRole());

        // 수정된 사용자 저장
        userRepository.save(existingUser);

        // 업데이트된 사용자 정보 반환
        return new UserDto(existingUser.getId(), existingUser.getUsername(), existingUser.getEmail(), existingUser.getRole(), existingUser.getCreatedAt(), existingUser.getUpdatedAt());
    }

    // 사용자 삭제
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}