package com.todolist.spring.todolistt.core.usecase.task_usecases;

import com.todolist.spring.todolistt.core.domain.dto.TaskDTO;
import com.todolist.spring.todolistt.core.domain.mapper.TaskMapper;
import com.todolist.spring.todolistt.core.domain.repository.TaskRepository;
import com.todolist.spring.todolistt.core.exception.TaskNotFoundException;

public class GetTaskByIdUseCase {
    private final TaskRepository taskRepository;

    public GetTaskByIdUseCase(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public TaskDTO getTaskById(Long id) {
        return taskRepository.getById(id)
                .map(TaskMapper::toDto)
                .orElseThrow(() -> new TaskNotFoundException("Task not found with id: " + id));
    }
}
