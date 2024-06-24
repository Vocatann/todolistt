package com.todolist.spring.todolistt.core.usecase.task_usecases;

import com.todolist.spring.todolistt.core.domain.dto.TaskDTO;
import com.todolist.spring.todolistt.core.domain.mapper.TaskMapper;
import com.todolist.spring.todolistt.core.domain.model.Task;
import com.todolist.spring.todolistt.core.domain.repository.TaskRepository;

public class SaveTaskUseCase {

    private final TaskRepository taskRepository;

    public SaveTaskUseCase(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void save(TaskDTO taskDTO) {
        Task task = TaskMapper.toEntity(taskDTO);
        taskRepository.save(task);
    }
}
