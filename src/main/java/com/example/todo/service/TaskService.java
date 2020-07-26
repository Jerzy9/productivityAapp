package com.example.todo.service;

import com.example.todo.dao.TaskDao;
import com.example.todo.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TaskService {
    private final TaskDao taskDao;

    @Autowired
    public TaskService(@Qualifier("fake") TaskDao taskDao) {
        this.taskDao = taskDao;
    }

    public int addTask(Task task) {
        return taskDao.insertTask(task);
    }

    public List<Task> getAllTasks() {
        return taskDao.getAllTasks();
    }

    public Optional<Task> selectById(UUID id) {
        return taskDao.selectTaskById(id);
    }

    public int deleteTask(UUID id) {
        return taskDao.deleteTask(id);
    }

    public Task getLatestTask() {
        return taskDao.getLastTask();
    }
}
