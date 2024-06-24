package com.todolist.spring.todolistt.configuration.controller;

import com.todolist.spring.todolistt.core.usecase.task_usecases.*;
import com.todolist.spring.todolistt.core.domain.dto.TaskDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/task")
public class TaskController {

    private final UpdateTaskUseCase updateTask;
    private final SaveTaskUseCase saveTask;
    private final DeleteTaskUseCase deleteTask;
    private final FindTaskByIdUseCase findTaskByIdUseCase;
    private final FindAllTasksUseCase findAllTasksUseCase;

    public TaskController(UpdateTaskUseCase updateTask, SaveTaskUseCase saveTask, DeleteTaskUseCase deleteTask, FindTaskByIdUseCase findTaskByIdUseCase, FindAllTasksUseCase findAllTasksUseCase) {
        this.updateTask = updateTask;
        this.saveTask = saveTask;
        this.deleteTask = deleteTask;
        this.findTaskByIdUseCase = findTaskByIdUseCase;
        this.findAllTasksUseCase = findAllTasksUseCase;
    }

    @PostMapping
    public ResponseEntity<TaskDTO> addTask(@RequestBody TaskDTO taskDTO) {
        saveTask.save(taskDTO);
        return new ResponseEntity<>(taskDTO, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Void> updateTask(@RequestBody TaskDTO taskDTO) {
        updateTask.update(taskDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskDTO> findTaskById(@PathVariable long id) {
        TaskDTO taskDTO = findTaskByIdUseCase.getTaskById(id);
        return new ResponseEntity<>(taskDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<TaskDTO>> findAllTasks() {
        List<TaskDTO> tasks = findAllTasksUseCase.findAllTasks();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable long id) {
        deleteTask.deleteTask(id);
        return ResponseEntity.ok().build();
    }
}
