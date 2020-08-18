package com.example.todo.dao;

import com.example.todo.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class TaskDaoAccessService implements TaskDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TaskDaoAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertTask(UUID id, Task newTask) {
        final String sql = "INSERT INTO tasks (id, name, text) VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql, id, newTask.getName(), newTask.getText());
    }

    @Override
    public List<Task> getAllTasks() {
        final String sql = "SELECT id, name, text FROM tasks";

        return jdbcTemplate.query(sql, ((resultSet, i) -> {
            UUID id = UUID.fromString(resultSet.getString("id"));
            String name = resultSet.getString("name");
            String text = resultSet.getString("text");

            return new Task(id, name, text);
        }));
    }

    @Override
    public Optional<Task> selectTaskById(UUID id) {
        return getAllTasks().stream().filter(task -> task.getId().equals(id)).findFirst();
    }

    @Override
    public int deleteTask(UUID id) {
        final String sql = "DELETE FROM tasks WHERE id='" + id + "'";
        return jdbcTemplate.update(sql);
    }

    @Override
    public Task getLastTask() {
        final String sql = "SELECT id, name, texts FROM task GROUP BY id DESC LIMIT";
//        Task task = jdbcTemplate.query(sql, ((resultSet, i) -> {
//            UUID id = UUID.fromString(resultSet.getString("id"));
//            String name = resultSet.getString("name");
//            String text = resultSet.getString("text");
//d
//            return new Task(id, name, text);
//        }));
        return null;
    }
}
