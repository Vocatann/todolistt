package com.todolist.spring.todolistt.core.usecase.task_usecases;

import com.todolist.spring.todolistt.core.domain.model.Task;
import com.todolist.spring.todolistt.core.domain.repository.TaskRepository;

public class SaveTask {

    private final TaskRepository taskRepository;

    public SaveTask(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task save(Task task) {
        return taskRepository.save(task);
    }
}
