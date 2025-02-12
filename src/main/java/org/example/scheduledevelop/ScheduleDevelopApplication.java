package org.example.scheduledevelop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaAuditing
@EntityScan(basePackages = "org.example.scheduledevelop.entity")
@EnableJpaRepositories(basePackages = "org.example.scheduledevelop.repository")
public class ScheduleDevelopApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScheduleDevelopApplication.class, args);
    }

}
