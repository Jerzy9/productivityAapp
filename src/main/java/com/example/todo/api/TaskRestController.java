package com.example.todo.api;

import com.example.todo.model.Task;
import com.example.todo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/task")
public class TaskRestController {
    private final TaskService taskService;

    @Autowired
    public TaskRestController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public void addTask(@RequestBody @Valid @NotNull Task task) {
        taskService.addTask(task);
    }
    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }
    @GetMapping("{id}")
    public Optional<Task> selectkById(@PathVariable("id") UUID id) {
        return taskService.selectById(id);
    }
    @DeleteMapping("{id}")
    public void deleteTaks(@PathVariable("id")  UUID id) {
        taskService.deleteTask(id);
    }
}
