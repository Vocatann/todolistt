package com.todolist.spring.todolistt.domain.usecase.task_usecases;

import com.todolist.spring.todolistt.domain.model.Task;
import com.todolist.spring.todolistt.domain.repository.TaskRepository;

public class GetTaskById {
    private final TaskRepository taskRepository;

    public GetTaskById(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task findTaskById(Long id) {
        return taskRepository.getById(id);
    }
}
