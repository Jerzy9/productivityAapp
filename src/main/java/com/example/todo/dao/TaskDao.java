package com.example.todo.dao;

import com.example.todo.model.Task;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TaskDao {

    int insertTask(UUID id, Task newTask);

    default int insertTask(Task newTask) {
        UUID id = UUID.randomUUID();
        return insertTask(id, newTask);
    }

    List<Task> getAllTasks();

    Optional<Task> selectTaskById(UUID id);

    int deleteTask(UUID id);

    Task getLastTask();
}
