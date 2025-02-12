package org.example.scheduledevelop.controller;

import org.example.scheduledevelop.dto.ScheduleRequestDto;
import org.example.scheduledevelop.dto.ScheduleResponseDto;
import org.example.scheduledevelop.service.ScheduleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedules")  // 일정 관련 API 경로
public class ScheduleController {

    private final ScheduleService scheduleService;

    // 생성자 주입을 통해 ScheduleService를 주입받음
    public ScheduleController(ScheduleService scheduleService){
        this.scheduleService = scheduleService;
    }

    // 일정 생성 (POST)
    @PostMapping
    public ResponseEntity<ScheduleResponseDto> createSchedule(@RequestBody ScheduleRequestDto dto) {
        // 서비스 메서드 호출하여 일정 생성
        ScheduleResponseDto response = scheduleService.createSchedule(dto);
        // 생성된 일정 정보와 상태 코드(201 Created) 반환
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // 일정 조회 (단건, GET)
    @GetMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> findScheduleById(@PathVariable Long id) {
        // 서비스 메서드로 일정을 찾고 응답
        ScheduleResponseDto response = scheduleService.getScheduleById(id);
        // 상태 코드(200 OK)로 응답 반환
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // 모든 일정 조회 (GET)
    @GetMapping
    public ResponseEntity<List<ScheduleResponseDto>> getAllSchedules() {
        // 모든 일정 조회
        List<ScheduleResponseDto> schedules = scheduleService.getAllSchedules();
        // 상태 코드(200 OK)로 응답 반환
        return new ResponseEntity<>(schedules, HttpStatus.OK);
    }

    // 일정 수정 (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> updateSchedule(@PathVariable Long id, @RequestBody ScheduleRequestDto dto) {
        // 서비스 메서드로 일정 수정 후 응답
        ScheduleResponseDto response = scheduleService.updateSchedule(id, dto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // 일정 삭제 (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable Long id) {
        // 서비스 메서드로 일정 삭제
        scheduleService.deleteSchedule(id);
        // 삭제 후 상태 코드(204 No Content) 반환
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
