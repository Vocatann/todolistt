package com.todolist.spring.todolistt.core.usecase.task_usecases;

import com.todolist.spring.todolistt.core.domain.dto.TaskDTO;
import com.todolist.spring.todolistt.core.domain.mapper.TaskMapper;
import com.todolist.spring.todolistt.core.domain.repository.TaskRepository;

import java.util.List;
import java.util.stream.Collectors;

public class FindAllTasksUseCase {

    private final TaskRepository taskRepository;

    public FindAllTasksUseCase(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<TaskDTO> findAllTasks() {
        return taskRepository.findAll().stream().map((task) -> TaskMapper.toDto(task)).collect(Collectors.toList());
    }
}
