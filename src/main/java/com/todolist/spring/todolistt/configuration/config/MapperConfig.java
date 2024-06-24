package com.todolist.spring.todolistt.configuration.config;

import com.todolist.spring.todolistt.core.domain.mapper.TaskMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean
    public TaskMapper taskMapper() {
        return new TaskMapper();
    }
}
