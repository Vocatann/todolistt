package com.todolist.spring.todolistt.core.usecase;

import com.todolist.spring.todolistt.core.domain.dto.TaskDTO;

import java.util.List;

public interface TaskService {
    void saveTask(TaskDTO taskDTO);
    List<TaskDTO> findAllTasks();
    TaskDTO findTaskById(Long id);
    void deleteTask(Long id);
}
