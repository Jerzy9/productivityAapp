package com.example.todo.dao;

import com.example.todo.model.Task;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fake")
public class FakeTaskDaoAccessService implements TaskDao {

    private List<Task> allTasks = new ArrayList<>();

    @Override
    public int insertTask(UUID id, Task newTask) {
        allTasks.add(new Task(id, newTask.getName(), newTask.getText()));
        return 1;
    }

    @Override
    public List<Task> getAllTasks() {
        return allTasks;
    }
    //
    @Override
    public Optional<Task> selectTaskById(UUID id) {
        return allTasks.stream().filter(task -> task.getId().equals(id)).findFirst();
    }

    @Override
    public int deleteTask(UUID id) {
        Optional<Task> taskToDelete = selectTaskById(id);
        if(taskToDelete.isEmpty()) {
            return 0;
        }
        allTasks.remove(taskToDelete.get());
        return 1;
    }

    @Override
    public Task getLastTask() {
        if (!allTasks.isEmpty()) {
            return allTasks.get(allTasks.size() - 1);
        }
        return null;
    }

}
