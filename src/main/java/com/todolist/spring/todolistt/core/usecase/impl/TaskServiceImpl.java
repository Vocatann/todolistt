package com.todolist.spring.todolistt.core.usecase.impl;

import com.todolist.spring.todolistt.core.domain.dto.TaskDTO;
import com.todolist.spring.todolistt.core.domain.mapper.TaskMapper;
import com.todolist.spring.todolistt.core.domain.model.Task;
import com.todolist.spring.todolistt.core.domain.repository.TaskRepository;
import com.todolist.spring.todolistt.core.exception.ResourceNotFoundException;
import com.todolist.spring.todolistt.core.usecase.TaskService;

import java.util.List;
import java.util.stream.Collectors;

public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    @Override
    public void saveTask(TaskDTO taskDTO) {
        Task task = TaskMapper.toEntity(taskDTO);
        taskRepository.save(task);
    }

    @Override
    public List<TaskDTO> findAllTasks() {
        return taskRepository.findAll().stream().map((task) -> TaskMapper.toDto(task)).collect(Collectors.toList());
    }

    @Override
    public TaskDTO findTaskById(Long id) {
        return taskRepository.findById(id)
                .map(TaskMapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with id: " + id));
    }

    @Override
    public void deleteTask(Long id) {
        Task task = taskRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Task not found with id: " + id)
        );

        taskRepository.deleteById(id);
    }

    @Override
    public void updateTask(TaskDTO taskDTO) {
        Task task = TaskMapper.toEntity(taskDTO);
        taskRepository.update(task);
    }
}
