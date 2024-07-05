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
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setId(1L);
        taskDTO.setTitle("Sample Task");
        taskDTO.setDescription("This is a sample task");
        taskDTO.setCompleted(true);
        taskDTO.setUserId(100L);

        Task task = new Task();
        task.setId(1L);
        task.setTitle("Sample Task");
        task.setDescription("This is a sample task");
        task.setIscompleted(true);
        task.setUserId(100L);

        taskService.saveTask(taskDTO);

        ArgumentCaptor<Task> taskCaptor = ArgumentCaptor.forClass(Task.class);
        verify(taskRepository).save(taskCaptor.capture());
        Task savedTask = taskCaptor.getValue();

        assertEquals(taskDTO.getId(), savedTask.getId());
        assertEquals(taskDTO.getTitle(), savedTask.getTitle());
        assertEquals(taskDTO.getDescription(), savedTask.getDescription());
        assertEquals(taskDTO.getIsCompleted(), savedTask.getIscompleted());
        assertEquals(taskDTO.getUserId(), savedTask.getUserId());
    }

    @Test
    public void testFindAllTasks() {
        Task task1 = new Task();
        task1.setId(1L);
        task1.setTitle("Sample Task");
        task1.setDescription("This is a sample task");
        task1.setIscompleted(true);
        task1.setUserId(100L);

        Task task2 = new Task();
        task2.setId(1L);
        task2.setTitle("Sample Task");
        task2.setDescription("This is a sample task");
        task2.setIscompleted(true);
        task2.setUserId(100L);

        when(taskRepository.findAll()).thenReturn(Arrays.asList(task1, task2));

        List<TaskDTO> taskDTOs = taskService.findAllTasks();

        assertEquals(2, taskDTOs.size());
        assertEquals(task1.getId(), taskDTOs.get(0).getId());
        assertEquals(task1.getTitle(), taskDTOs.get(0).getTitle());
        assertEquals(task1.getDescription(), taskDTOs.get(0).getDescription());
        assertEquals(task1.getIscompleted(), taskDTOs.get(0).getIsCompleted());
        assertEquals(task1.getUserId(), taskDTOs.get(0).getUserId());
        assertEquals(task2.getId(), taskDTOs.get(1).getId());
        assertEquals(task2.getTitle(), taskDTOs.get(1).getTitle());
        assertEquals(task2.getDescription(), taskDTOs.get(1).getDescription());
        assertEquals(task2.getIscompleted(), taskDTOs.get(1).getIsCompleted());
        assertEquals(task2.getUserId(), taskDTOs.get(1).getUserId());
    }

    @Test
    public void testFindTaskById() {
        Long taskId = 1L;
        Task task = new Task();
        task.setId(taskId);
        task.setTitle("Sample Task");
        task.setDescription("This is a sample task");
        task.setIscompleted(true);
        task.setUserId(100L);

        when(taskRepository.findById(taskId)).thenReturn(Optional.of(task));

        TaskDTO taskDTO = taskService.findTaskById(taskId);

        assertNotNull(taskDTO);
        assertEquals(task.getId(), taskDTO.getId());
        assertEquals(task.getTitle(), taskDTO.getTitle());
        assertEquals(task.getDescription(), taskDTO.getDescription());
        assertEquals(task.getIscompleted(), taskDTO.getIsCompleted());
        assertEquals(task.getUserId(), taskDTO.getUserId());
    }

    @Test
    public void testFindTaskById_NotFound() {
        Long taskId = 1L;
        when(taskRepository.findById(taskId)).thenReturn(Optional.empty());

        ResourceNotFoundException exception = assertThrows(
                ResourceNotFoundException.class,
                () -> taskService.findTaskById(taskId)
        );

        assertEquals("Task not found with id: " + taskId, exception.getMessage());
    }

    @Test
    public void testDeleteTask() {
        Long taskId = 1L;
        Task task = new Task();
        task.setId(taskId);
        task.setTitle("Sample Task");
        task.setDescription("This is a sample task");
        task.setIscompleted(true);
        task.setUserId(100L);

        when(taskRepository.findById(taskId)).thenReturn(Optional.of(task));

        taskService.deleteTask(taskId);

        verify(taskRepository).deleteById(taskId);
    }

    @Test
    public void testDeleteTask_NotFound() {
        Long taskId = 1L;
        when(taskRepository.findById(taskId)).thenReturn(Optional.empty());

        ResourceNotFoundException exception = assertThrows(
                ResourceNotFoundException.class,
                () -> taskService.deleteTask(taskId)
        );

        assertEquals("Task not found with id: " + taskId, exception.getMessage());
    }
}
