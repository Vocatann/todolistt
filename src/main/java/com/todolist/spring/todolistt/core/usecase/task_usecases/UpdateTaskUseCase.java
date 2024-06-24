package com.todolist.spring.todolistt.core.usecase.task_usecases;

import com.todolist.spring.todolistt.core.domain.dto.TaskDTO;
import com.todolist.spring.todolistt.core.domain.mapper.TaskMapper;
import com.todolist.spring.todolistt.core.domain.model.Task;
import com.todolist.spring.todolistt.core.domain.repository.TaskRepository;

public class UpdateTaskUseCase {

    private final TaskRepository taskRepository;

    public UpdateTaskUseCase(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    public void update(TaskDTO taskDTO){
        Task task = TaskMapper.toEntity(taskDTO);
        taskRepository.update(task);
    }
}
