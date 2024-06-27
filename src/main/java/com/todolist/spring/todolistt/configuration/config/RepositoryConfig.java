package com.todolist.spring.todolistt.configuration.config;

import com.todolist.spring.todolistt.core.domain.repository.TaskRepository;
import com.todolist.spring.todolistt.infrastructure.persistence.PostgreSQLTaskRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryConfig {

    @Bean
    public TaskRepository taskRepository() {
        return new PostgreSQLTaskRepository();
    }
}
