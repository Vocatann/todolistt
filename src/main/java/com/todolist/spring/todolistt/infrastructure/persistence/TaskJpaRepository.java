package com.todolist.spring.todolistt.infrastructure.persistence;

import com.todolist.spring.todolistt.domain.model.Task;
import com.todolist.spring.todolistt.domain.repository.TaskRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskJpaRepository extends JpaRepository<Task, Long>, TaskRepository {
}
