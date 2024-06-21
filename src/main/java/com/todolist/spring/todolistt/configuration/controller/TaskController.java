package com.todolist.spring.todolistt.configuration.controller;

import com.todolist.spring.todolistt.core.domain.model.Task;
import com.todolist.spring.todolistt.core.usecase.task_usecases.SaveTask;
import com.todolist.spring.todolistt.configuration.dto.TaskDTO;
import com.todolist.spring.todolistt.configuration.mapper.TaskMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/task")
public class TaskController {

    private final SaveTask saveTask;
    private final TaskMapper taskMapper;

    public TaskController(SaveTask saveTask, TaskMapper taskMapper) {
        this.saveTask = saveTask;
        this.taskMapper = taskMapper;
    }

    @PostMapping
    public ResponseEntity<Task> addTask(@RequestBody TaskDTO taskDTO) {
        Task task = taskMapper.toEntity(taskDTO);
        task = saveTask.save(task);
        return new ResponseEntity<>(task, HttpStatus.CREATED);
    }
}
