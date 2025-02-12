package org.example.scheduledevelop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.scheduledevelop.entity.Schedule;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ScheduleResponseDto {

    private Long id;
    private String task;
    private String description;
    private String username;  // User의 이름 추가

    public ScheduleResponseDto(Schedule schedule) {
        this.id = schedule.getId();
        this.task = schedule.getTask();
        this.description = schedule.getDescription();
        this.username = schedule.getUser().getUsername();  // User의 이름 포함
    }

}
