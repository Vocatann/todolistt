package com.todolist.spring.todolistt.core.usecase.task_usecases;

import com.todolist.spring.todolistt.core.domain.repository.TaskRepository;

public class DeleteTask {
    private final TaskRepository taskRepository;

    public DeleteTask(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
