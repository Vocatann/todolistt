package com.todolist.spring.todolistt.infrastructure.persistence;

import com.todolist.spring.todolistt.core.domain.model.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class GenericRepositoryImplTest {

    @Mock
    private EntityManager em;

    @Mock
    private TypedQuery<Task> query;

    @InjectMocks
    private GenericRepositoryImpl<Task> taskRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        taskRepository = new GenericRepositoryImpl<>(Task.class);
        taskRepository.em = em;
    }

    @Test
    public void testSave_NewEntity() {
        Task task = new Task();
        when(em.contains(task)).thenReturn(false);

        taskRepository.save(task);

        verify(em).persist(task);
        verify(em, never()).merge(task);
    }

    @Test
    public void testSave_ExistingEntity() {
        Task task = new Task();
        when(em.contains(task)).thenReturn(true);

        taskRepository.save(task);

        verify(em).merge(task);
        verify(em, never()).persist(task);
    }

    @Test
    public void testFindById() {
        Long id = 1L;
        Task task = new Task();
        when(em.find(Task.class, id)).thenReturn(task);

        Optional<Task> result = taskRepository.findById(id);

        assertTrue(result.isPresent());
        assertEquals(task, result.get());
    }

    @Test
    public void testFindById_NotFound() {
        Long id = 1L;
        when(em.find(Task.class, id)).thenReturn(null);

        Optional<Task> result = taskRepository.findById(id);

        assertFalse(result.isPresent());
    }

    @Test
    public void testFindAll() {
        Task task1 = new Task();
        Task task2 = new Task();
        when(em.createQuery(anyString(), eq(Task.class))).thenReturn(query);
        when(query.getResultList()).thenReturn(Arrays.asList(task1, task2));

        List<Task> tasks = taskRepository.findAll();

        assertEquals(2, tasks.size());
        assertEquals(task1, tasks.get(0));
        assertEquals(task2, tasks.get(1));
    }

    @Test
    public void testDeleteById() {
        Long id = 1L;
        Task task = new Task();
        when(em.find(Task.class, id)).thenReturn(task);

        taskRepository.deleteById(id);

        verify(em).remove(task);
    }
}