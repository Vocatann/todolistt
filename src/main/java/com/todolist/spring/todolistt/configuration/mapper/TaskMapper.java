package com.todolist.spring.todolistt.configuration.mapper;

import com.todolist.spring.todolistt.core.domain.model.Task;
import com.todolist.spring.todolistt.configuration.dto.TaskDTO;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {
    public Task toEntity(TaskDTO dto) {
        Task task = new Task();
        task.setId(dto.getId());
        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());
        task.setCompleted(dto.isCompleted());
        return task;
    }

    public TaskDTO toDto(Task task) {
        TaskDTO dto = new TaskDTO();
        dto.setId(task.getId());
        dto.setTitle(task.getTitle());
        dto.setDescription(task.getDescription());
        dto.setCompleted(task.isCompleted());
        return dto;
    }
}
