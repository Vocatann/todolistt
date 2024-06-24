package com.todolist.spring.todolistt.core.usecase.task_usecases;

import com.todolist.spring.todolistt.core.domain.model.Task;
import com.todolist.spring.todolistt.core.domain.repository.TaskRepository;
import com.todolist.spring.todolistt.core.exception.ResourceNotFoundException;

public class DeleteTaskUseCase {
    private final TaskRepository taskRepository;

    public DeleteTaskUseCase(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void deleteTask(Long id) {
        Task task = taskRepository.getById(id).orElseThrow(
                () -> new ResourceNotFoundException("Task not found with id: " + id)
        );

        taskRepository.deleteById(id);
    }
}
