package org.example.scheduledevelop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.scheduledevelop.entity.Schedule;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ScheduleResponseDto {
    private Long id;               // 일정 ID
    private String task;           // 일정 제목
    private String author;         // 작성자 이름
    private String description;    // 일정 내용
    private LocalDateTime createdAt; // 생성일
    private LocalDateTime updatedAt; // 수정일

    // Schedule 엔티티에서 데이터 초기화
    public ScheduleResponseDto(Schedule schedule) {
        this.id = schedule.getId();
        this.task = schedule.getTask();
        this.author = schedule.getAuthor();
        this.description = schedule.getDescription();
        this.createdAt = schedule.getCreatedAt();
        this.updatedAt = schedule.getUpdatedAt();
    }
}
