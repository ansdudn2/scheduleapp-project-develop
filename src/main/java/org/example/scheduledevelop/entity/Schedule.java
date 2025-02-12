package org.example.scheduledevelop.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.scheduledevelop.entity.User;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;  // 작성자 (User 객체)

    @Column(nullable = false)
    private String task;

    @Column(length = 1000)
    private String description;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime updatedAt;

    // 생성자: user, task, description만 받는 생성자
    public Schedule(User user, String task, String description) {
        this.user = user;
        this.task = task;
        this.description = description;
    }

    // password를 포함한 생성자
    public Schedule(User user, String task, String description, String password) {
        this.user = user;
        this.task = task;
        this.description = description;
        this.user.setPassword(password); // User 객체에 password 설정
    }

    // 일정 수정 메서드
    public void update(String task, String description) {
        this.task = task;
        this.description = description;
    }

    // User 정보에 접근할 수 있는 메서드
    public String getAuthor() {
        return this.user != null ? this.user.getUsername() : "";
    }

    public String getPassword() {
        return this.user != null ? this.user.getPassword() : "";
    }
}
