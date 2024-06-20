package com.todolist.spring.todolistt.core.domain.repository;



import com.todolist.spring.todolistt.core.domain.model.Task;

import java.util.List;

public interface TaskRepository {
    Task save(Task task);
    List<Task> findAll();
    Task getById(Long id);
    void deleteById(Long id);
}
