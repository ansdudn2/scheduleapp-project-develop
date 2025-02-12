CREATE DATABASE schedule_app;
USE schedule_app;

CREATE TABLE IF NOT EXISTS users (
                                     id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                     username VARCHAR(255) NOT NULL UNIQUE,
                                     email VARCHAR(255) NOT NULL UNIQUE,
                                     password VARCHAR(255) NOT NULL,
                                     createdAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
                                     updatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NOT NULL
);
CREATE TABLE schedules (
                           id BIGINT AUTO_INCREMENT PRIMARY KEY,
                           user_id BIGINT NOT NULL,
                           task VARCHAR(255) NOT NULL,
                           description VARCHAR(1000),
                           createdAt DATETIME NOT NULL,
                           updatedAt DATETIME NOT NULL,
                           FOREIGN KEY (user_id) REFERENCES users(id)
);


