package com.todolist.spring.todolistt.core.domain.repository;
import com.todolist.spring.todolistt.core.domain.model.Task;

import java.util.List;
import java.util.Optional;

public interface TaskRepository {
    void save(Task task);
    List<Task> findAll();
    Optional<Task> findById(Long id);
    void deleteById(Long id);
    void update(Task task);
}
