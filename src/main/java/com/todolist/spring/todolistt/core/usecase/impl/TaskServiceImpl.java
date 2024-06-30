package com.todolist.spring.todolistt.core.usecase.impl;

import com.todolist.spring.todolistt.core.domain.dto.TaskDTO;
import com.todolist.spring.todolistt.core.domain.mapper.TaskMapper;
import com.todolist.spring.todolistt.core.domain.model.Task;
import com.todolist.spring.todolistt.core.domain.repository.GenericRepository;
import com.todolist.spring.todolistt.core.exception.ResourceNotFoundException;
import com.todolist.spring.todolistt.core.usecase.TaskService;

import java.util.List;
import java.util.stream.Collectors;

public class TaskServiceImpl implements TaskService {

    private final GenericRepository<Task, Long> taskRepository;

    public TaskServiceImpl(GenericRepository<Task, Long> taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public void saveTask(TaskDTO taskDTO) {
        Task task = TaskMapper.toEntity(taskDTO);
        taskRepository.save(task);
    }

    @Override
    public List<TaskDTO> findAllTasks() {
        List<Task> tasks = taskRepository.findAll();
        return tasks.stream()
                .map(TaskMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public TaskDTO findTaskById(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with id: " + id));
        return TaskMapper.toDto(task);
    }

    @Override
    public void deleteTask(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with id: " + id));

        taskRepository.deleteById(id);
    }
}
