package com.todolist.spring.todolistt.configuration.config;

import com.todolist.spring.todolistt.core.domain.repository.TaskRepository;
import com.todolist.spring.todolistt.core.usecase.task_usecases.SaveTask;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    @Bean
    public SaveTask saveTaskUseCase(TaskRepository taskRepository){
        return new SaveTask(taskRepository);
    }
}
