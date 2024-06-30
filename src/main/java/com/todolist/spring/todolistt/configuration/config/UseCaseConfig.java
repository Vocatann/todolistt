package com.todolist.spring.todolistt.configuration.config;

import com.todolist.spring.todolistt.core.domain.model.Task;
import com.todolist.spring.todolistt.core.domain.repository.GenericRepository;
import com.todolist.spring.todolistt.core.usecase.TaskService;
import com.todolist.spring.todolistt.core.usecase.impl.TaskServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    @Bean
    public TaskService taskService(GenericRepository<Task, Long> genericRepository) {
        return new TaskServiceImpl(genericRepository);
    }
}
