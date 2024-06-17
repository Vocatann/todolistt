package com.todolist.spring.todolist.domain.usecase.task_usecases;

import com.todolist.spring.todolist.domain.repository.TaskRepository;

public class DeleteTask {
    private final TaskRepository taskRepository;

    public DeleteTask(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void deleteTask(Long id) {
        taskRepository.delete(id);
    }
}
