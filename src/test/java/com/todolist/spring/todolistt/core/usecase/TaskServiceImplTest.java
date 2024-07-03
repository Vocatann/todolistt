package com.todolist.spring.todolistt.core.usecase;

import com.todolist.spring.todolistt.core.domain.dto.TaskDTO;
import com.todolist.spring.todolistt.core.domain.model.Task;
import com.todolist.spring.todolistt.core.domain.repository.GenericRepository;
import com.todolist.spring.todolistt.core.exception.ResourceNotFoundException;
import com.todolist.spring.todolistt.core.usecase.impl.TaskServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class TaskServiceImplTest {

    @Mock
    private GenericRepository<Task, Long> taskRepository;

    @InjectMocks
    private TaskServiceImpl taskService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSaveTask() {
        // Arrange
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setId(1L);
        taskDTO.setTitle("Sample Task");

        Task task = new Task();
        task.setId(1L);
        task.setTitle("Sample Task");

        // Act
        taskService.saveTask(taskDTO);

        // Assert
        ArgumentCaptor<Task> taskCaptor = ArgumentCaptor.forClass(Task.class);
        verify(taskRepository).save(taskCaptor.capture());
        Task savedTask = taskCaptor.getValue();

        assertEquals(taskDTO.getId(), savedTask.getId());
        assertEquals(taskDTO.getTitle(), savedTask.getTitle());
    }

    @Test
    public void testFindAllTasks() {
        // Arrange
        Task task1 = new Task();
        task1.setId(1L);
        task1.setTitle("Task 1");

        Task task2 = new Task();
        task2.setId(2L);
        task2.setTitle("Task 2");

        when(taskRepository.findAll()).thenReturn(Arrays.asList(task1, task2));

        // Act
        List<TaskDTO> taskDTOs = taskService.findAllTasks();

        // Assert
        assertEquals(2, taskDTOs.size());
        assertEquals(task1.getId(), taskDTOs.get(0).getId());
        assertEquals(task1.getTitle(), taskDTOs.get(0).getTitle());
        assertEquals(task2.getId(), taskDTOs.get(1).getId());
        assertEquals(task2.getTitle(), taskDTOs.get(1).getTitle());
    }

    @Test
    public void testFindTaskById() {
        // Arrange
        Long taskId = 1L;
        Task task = new Task();
        task.setId(taskId);
        task.setTitle("Sample Task");

        when(taskRepository.findById(taskId)).thenReturn(Optional.of(task));

        // Act
        TaskDTO taskDTO = taskService.findTaskById(taskId);

        // Assert
        assertNotNull(taskDTO);
        assertEquals(task.getId(), taskDTO.getId());
        assertEquals(task.getTitle(), taskDTO.getTitle());
    }

    @Test
    public void testFindTaskById_NotFound() {
        // Arrange
        Long taskId = 1L;
        when(taskRepository.findById(taskId)).thenReturn(Optional.empty());

        // Act & Assert
        ResourceNotFoundException exception = assertThrows(
                ResourceNotFoundException.class,
                () -> taskService.findTaskById(taskId)
        );

        assertEquals("Task not found with id: " + taskId, exception.getMessage());
    }

    @Test
    public void testDeleteTask() {
        // Arrange
        Long taskId = 1L;
        Task task = new Task();
        task.setId(taskId);
        task.setTitle("Sample Task");

        when(taskRepository.findById(taskId)).thenReturn(Optional.of(task));

        // Act
        taskService.deleteTask(taskId);

        // Assert
        verify(taskRepository).deleteById(taskId);
    }

    @Test
    public void testDeleteTask_NotFound() {
        // Arrange
        Long taskId = 1L;
        when(taskRepository.findById(taskId)).thenReturn(Optional.empty());

        // Act & Assert
        ResourceNotFoundException exception = assertThrows(
                ResourceNotFoundException.class,
                () -> taskService.deleteTask(taskId)
        );

        assertEquals("Task not found with id: " + taskId, exception.getMessage());
    }
}
