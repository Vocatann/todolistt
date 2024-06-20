package com.todolist.spring.todolistt.infrastructure.persistence;

import com.todolist.spring.todolistt.core.domain.model.Task;
import com.todolist.spring.todolistt.core.domain.repository.TaskRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import java.util.List;

@Transactional
public class TaskRepositoryImpl implements TaskRepository {

    private final EntityManager entityManager;

    public TaskRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Task save(Task task) {
        if (task.getId() == null) {
            entityManager.persist(task);
        } else {
            entityManager.merge(task);
        }
        return task;
    }

    @Override
    public List<Task> findAll() {
        return entityManager.createQuery("from Task", Task.class).getResultList();
    }

    @Override
    public Task getById(Long id) {
        return entityManager.find(Task.class, id);
    }

    @Override
    public void deleteById(Long id) {
        Task task = getById(id);
        if (task != null) {
            entityManager.remove(task);
        }
    }
}
