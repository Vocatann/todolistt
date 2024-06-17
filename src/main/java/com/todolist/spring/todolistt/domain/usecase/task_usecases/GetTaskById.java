package com.todolist.spring.todolist.domain.usecase.task_usecases;

import com.todolist.spring.todolist.domain.model.Task;
import com.todolist.spring.todolist.domain.repository.TaskRepository;

public class GetTaskById {
    private final TaskRepository taskRepository;

    public GetTaskById(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task findTaskById(Long id) {
        return taskRepository.getById(id);
    }
}
