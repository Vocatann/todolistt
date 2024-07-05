package com.todolist.spring.todolistt.configuration.controller;

import com.todolist.spring.todolistt.core.domain.dto.TaskDTO;
import com.todolist.spring.todolistt.core.usecase.TaskService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(TaskController.class)
public class TaskControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TaskService taskService;

    @Test
    public void testAddTask() throws Exception {
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setId(1L);
        taskDTO.setTitle("Sample Task");
        taskDTO.setDescription("Sample Description");
        taskDTO.setCompleted(false);
        taskDTO.setUserId(1L);

        mockMvc.perform(post("/api/tasks")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":1,\"title\":\"Sample Task\",\"description\":\"Sample Description\",\"iscompleted\":false,\"userId\":1}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.title", is("Sample Task")))
                .andExpect(jsonPath("$.description", is("Sample Description")))
                .andExpect(jsonPath("$.iscompleted", is(false)))
                .andExpect(jsonPath("$.userId", is(1)));

        verify(taskService, times(1)).saveTask(any(TaskDTO.class));
    }

    @Test
    public void testUpdateTask() throws Exception {
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setId(1L);
        taskDTO.setTitle("Updated Task");
        taskDTO.setDescription("Updated Description");
        taskDTO.setCompleted(true);
        taskDTO.setUserId(1L);

        mockMvc.perform(put("/api/tasks")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":1,\"title\":\"Updated Task\",\"description\":\"Updated Description\",\"iscompleted\":true,\"userId\":1}"))
                .andExpect(status().isOk());

        verify(taskService, times(1)).saveTask(any(TaskDTO.class));
    }

    @Test
    public void testFindTaskById() throws Exception {
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setId(1L);
        taskDTO.setTitle("Sample Task");
        taskDTO.setDescription("Sample Description");
        taskDTO.setCompleted(false);
        taskDTO.setUserId(1L);

        given(taskService.findTaskById(1L)).willReturn(taskDTO);

        mockMvc.perform(get("/api/tasks/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.title", is("Sample Task")))
                .andExpect(jsonPath("$.description", is("Sample Description")))
                .andExpect(jsonPath("$.iscompleted", is(false)))
                .andExpect(jsonPath("$.userId", is(1)));

        verify(taskService, times(1)).findTaskById(1L);
    }

    @Test
    public void testFindAllTasks() throws Exception {
        TaskDTO task1 = new TaskDTO();
        task1.setId(1L);
        task1.setTitle("Task 1");
        task1.setDescription("Description 1");
        task1.setCompleted(false);
        task1.setUserId(1L);

        TaskDTO task2 = new TaskDTO();
        task2.setId(2L);
        task2.setTitle("Task 2");
        task2.setDescription("Description 2");
        task2.setCompleted(true);
        task2.setUserId(2L);

        List<TaskDTO> tasks = Arrays.asList(task1, task2);

        given(taskService.findAllTasks()).willReturn(tasks);

        mockMvc.perform(get("/api/tasks")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].title", is("Task 1")))
                .andExpect(jsonPath("$[0].description", is("Description 1")))
                .andExpect(jsonPath("$[0].iscompleted", is(false)))
                .andExpect(jsonPath("$[0].userId", is(1)))
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[1].title", is("Task 2")))
                .andExpect(jsonPath("$[1].description", is("Description 2")))
                .andExpect(jsonPath("$[1].iscompleted", is(true)))
                .andExpect(jsonPath("$[1].userId", is(2)));

        verify(taskService, times(1)).findAllTasks();
    }

    @Test
    public void testDeleteTask() throws Exception {
        mockMvc.perform(delete("/api/tasks/1"))
                .andExpect(status().isOk());

        verify(taskService, times(1)).deleteTask(1L);
    }
}
