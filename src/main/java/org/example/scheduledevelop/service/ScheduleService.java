package org.example.scheduledevelop.service;

import org.example.scheduledevelop.dto.ScheduleRequestDto;
import org.example.scheduledevelop.dto.ScheduleResponseDto;
import org.example.scheduledevelop.entity.Schedule;
import org.example.scheduledevelop.entity.User;
import org.example.scheduledevelop.repository.ScheduleRepository;
import org.example.scheduledevelop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final UserRepository userRepository;

    @Autowired
    public ScheduleService(ScheduleRepository scheduleRepository, UserRepository userRepository) {
        this.scheduleRepository = scheduleRepository;
        this.userRepository = userRepository;
    }

    // 일정 생성
    public ScheduleResponseDto createSchedule(ScheduleRequestDto requestDto) {
        User user = userRepository.findByUsername(requestDto.getAuthor());
        Schedule schedule = new Schedule(user, requestDto.getTask(), requestDto.getDescription());
        scheduleRepository.save(schedule);
        return new ScheduleResponseDto(schedule);
    }

    // 일정 조회 (단건)
    public ScheduleResponseDto getScheduleById(Long id) {
        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Schedule not found"));
        return new ScheduleResponseDto(schedule);
    }

    // 모든 일정 조회
    public List<ScheduleResponseDto> getAllSchedules() {
        List<Schedule> schedules = scheduleRepository.findAll();
        return schedules.stream()
                .map(ScheduleResponseDto::new)
                .collect(Collectors.toList());
    }

    // 일정 수정
    public ScheduleResponseDto updateSchedule(Long id, ScheduleRequestDto requestDto) {
        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Schedule not found"));
        schedule.update(requestDto.getTask(), requestDto.getDescription());
        scheduleRepository.save(schedule);
        return new ScheduleResponseDto(schedule);
    }

    // 일정 삭제
    public void deleteSchedule(Long id) {
        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Schedule not found"));
        scheduleRepository.delete(schedule);
    }
}
