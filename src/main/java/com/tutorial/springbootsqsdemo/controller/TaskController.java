package com.tutorial.springbootsqsdemo.controller;

import com.tutorial.springbootsqsdemo.model.Task;
import com.tutorial.springbootsqsdemo.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @PostMapping
    public ResponseEntity<String> addTask(@RequestBody Task task){
        taskService.submitTask(task);
        return ResponseEntity.accepted().body("Task submitted successfully");
    }
}
