package com.todolist.spring.todolistt.configuration.config;

import com.todolist.spring.todolistt.core.domain.repository.TaskRepository;
import com.todolist.spring.todolistt.core.usecase.task_usecases.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    @Bean
    public SaveTaskUseCase saveTaskUseCase(TaskRepository taskRepository){
        return new SaveTaskUseCase(taskRepository);
    }

    @Bean
    public UpdateTaskUseCase updateTaskUseCase(TaskRepository taskRepository){
        return new UpdateTaskUseCase(taskRepository);
    }

    @Bean
    public DeleteTaskUseCase deleteTaskUseCase(TaskRepository taskRepository){
        return new DeleteTaskUseCase(taskRepository);
    }

    @Bean
    public GetTaskByIdUseCase getTaskByIdUseCase(TaskRepository taskRepository){
        return new GetTaskByIdUseCase(taskRepository);
    }
}
