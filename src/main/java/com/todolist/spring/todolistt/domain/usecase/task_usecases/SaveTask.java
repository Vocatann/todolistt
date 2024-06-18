package com.todolist.spring.todolistt.domain.usecase.task_usecases;

import com.todolist.spring.todolistt.domain.model.Task;
import com.todolist.spring.todolistt.domain.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaveTask {

    private final TaskRepository taskRepository;

    public SaveTask(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task save(Task task) {
        return taskRepository.save(task);
    }
}
