package com.todolist.spring.todolistt.domain.usecase.task_usecases;

import com.todolist.spring.todolistt.domain.repository.TaskRepository;

public class DeleteTask {
    private final TaskRepository taskRepository;

    public DeleteTask(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
