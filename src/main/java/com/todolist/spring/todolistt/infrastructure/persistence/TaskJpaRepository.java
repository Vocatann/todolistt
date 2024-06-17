package com.todolist.spring.todolist.infrastructure.persistence;

import com.todolist.spring.todolist.domain.model.Task;
import com.todolist.spring.todolist.domain.repository.TaskRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskJpaRepository extends JpaRepository<Task, Long>, TaskRepository {
}
