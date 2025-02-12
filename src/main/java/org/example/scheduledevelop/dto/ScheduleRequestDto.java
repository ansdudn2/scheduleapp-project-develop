package org.example.scheduledevelop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleRequestDto {

    private Long id;  // 일정 ID 추가
    private Long userId;  // 유저 ID 추가
    private String task;
    private String description;

}