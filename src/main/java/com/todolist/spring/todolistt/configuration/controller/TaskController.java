package com.todolist.spring.todolistt.configuration.controller;

import com.todolist.spring.todolistt.core.usecase.task_usecases.*;
import com.todolist.spring.todolistt.core.domain.dto.TaskDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/task")
public class TaskController {

    private final UpdateTaskUseCase updateTask;
    private final SaveTaskUseCase saveTask;
    private final DeleteTaskUseCase deleteTask;
    private final GetTaskByIdUseCase getTaskByIdUseCase;

    public TaskController(UpdateTaskUseCase updateTask, SaveTaskUseCase saveTask, DeleteTaskUseCase deleteTask, GetTaskByIdUseCase getTaskByIdUseCase) {
        this.updateTask = updateTask;
        this.saveTask = saveTask;
        this.deleteTask = deleteTask;
        this.getTaskByIdUseCase = getTaskByIdUseCase;
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
    public ResponseEntity<TaskDTO> getTaskById(@PathVariable long id) {
        TaskDTO taskDTO = getTaskByIdUseCase.getTaskById(id);
        return new ResponseEntity<>(taskDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable long id) {
        deleteTask.deleteTask(id);
        return ResponseEntity.ok().build();
    }
}
