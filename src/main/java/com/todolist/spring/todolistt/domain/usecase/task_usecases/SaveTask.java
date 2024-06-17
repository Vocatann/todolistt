package com.todolist.spring.todolist.domain.usecase.task_usecases;

import com.todolist.spring.todolist.domain.model.Task;
import com.todolist.spring.todolist.domain.repository.TaskRepository;

public class SaveTask {
    private final TaskRepository taskRepository;

    public SaveTask(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task save(Task task) {
        return taskRepository.save(task);
    }
}
