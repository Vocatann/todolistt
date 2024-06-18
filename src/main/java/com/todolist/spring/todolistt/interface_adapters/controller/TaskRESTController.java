package com.todolist.spring.todolistt.interface_adapters.controller;

import com.todolist.spring.todolistt.domain.model.Task;
import com.todolist.spring.todolistt.domain.usecase.task_usecases.SaveTask;
import com.todolist.spring.todolistt.interface_adapters.dto.TaskDTO;
import com.todolist.spring.todolistt.interface_adapters.mapper.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/task")
public class TaskRESTController {

    private final SaveTask saveTask;
    private final TaskMapper taskMapper;

    public TaskRESTController(TaskMapper taskMapper, SaveTask saveTask) {
        this.taskMapper = taskMapper;
        this.saveTask = saveTask;
    }

    @PostMapping
    public ResponseEntity<Task> addTask(@RequestBody TaskDTO taskDTO) {
        Task task = taskMapper.toEntity(taskDTO);
        task = this.saveTask.save(task);
        return new ResponseEntity<Task>(task, HttpStatus.CREATED);
    }
}
