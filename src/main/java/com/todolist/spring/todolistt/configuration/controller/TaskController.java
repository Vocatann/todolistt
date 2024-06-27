package com.todolist.spring.todolistt.configuration.controller;

import com.todolist.spring.todolistt.core.usecase.TaskService;
import com.todolist.spring.todolistt.core.domain.dto.TaskDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/task")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;

    }

    @PostMapping
    public ResponseEntity<TaskDTO> addTask(@RequestBody TaskDTO taskDTO) {
        taskService.saveTask(taskDTO);
        return new ResponseEntity<>(taskDTO, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Void> updateTask(@RequestBody TaskDTO taskDTO) {
        taskService.updateTask(taskDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskDTO> findTaskById(@PathVariable long id) {
        TaskDTO taskDTO = taskService.findTaskById(id);
        return new ResponseEntity<>(taskDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<TaskDTO>> findAllTasks() {
        List<TaskDTO> tasks = taskService.findAllTasks();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable long id) {
        taskService.deleteTask(id);
        return ResponseEntity.ok().build();
    }
}
