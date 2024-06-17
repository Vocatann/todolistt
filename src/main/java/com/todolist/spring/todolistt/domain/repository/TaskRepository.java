package com.todolist.spring.todolist.domain.repository;

import com.todolist.spring.todolist.domain.model.Task;

import java.util.List;

public interface TaskRepository {
    Task save(Task task);
    List<Task> findAll();
    Task getById(Long id);
    void delete(Long id);
}
