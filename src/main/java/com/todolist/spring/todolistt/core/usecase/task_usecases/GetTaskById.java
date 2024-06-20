package com.todolist.spring.todolistt.core.usecase.task_usecases;

import com.todolist.spring.todolistt.core.domain.model.Task;
import com.todolist.spring.todolistt.core.domain.repository.TaskRepository;

public class GetTaskById {
    private final TaskRepository taskRepository;

    public GetTaskById(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task findTaskById(Long id) {
        return taskRepository.getById(id);
    }
}
