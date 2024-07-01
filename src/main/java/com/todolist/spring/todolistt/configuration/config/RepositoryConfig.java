package com.todolist.spring.todolistt.configuration.config;

import com.todolist.spring.todolistt.core.domain.model.Task;
import com.todolist.spring.todolistt.core.domain.model.User;
import com.todolist.spring.todolistt.core.domain.repository.GenericRepository;
import com.todolist.spring.todolistt.infrastructure.persistence.GenericRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryConfig {

    @Bean
    public GenericRepository<Task, Long> taskRepository() {
        return new GenericRepositoryImpl<>(Task.class);
    }

    @Bean
    public GenericRepository<User, Long> userRepository() {
        return new GenericRepositoryImpl<>(User.class);
    }

    @Bean
    public GenericRepository<Task, Long> defaultRepository() {
        return new GenericRepositoryImpl<>(Task.class);
    }
}
