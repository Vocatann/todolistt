package com.todolist.spring.todolistt.configuration.config;

import com.todolist.spring.todolistt.core.domain.model.Task;
import com.todolist.spring.todolistt.core.domain.model.User;
import com.todolist.spring.todolistt.core.domain.repository.GenericRepository;
import com.todolist.spring.todolistt.core.usecase.TaskService;
import com.todolist.spring.todolistt.core.usecase.UserService;
import com.todolist.spring.todolistt.core.usecase.impl.TaskServiceImpl;
import com.todolist.spring.todolistt.core.usecase.impl.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    @Bean
    public TaskService taskService(GenericRepository<Task, Long> taskRepository) {
        return new TaskServiceImpl(taskRepository);
    }

    @Bean
    public UserService userService(GenericRepository<User, Long> userRepository) {
        return new UserServiceImpl(userRepository);
    }
}
