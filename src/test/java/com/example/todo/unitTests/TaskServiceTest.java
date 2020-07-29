package com.example.todo.unitTests;


import com.example.todo.dao.TaskDao;
import com.example.todo.model.Task;
import com.example.todo.service.TaskService;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;


@SpringBootTest
//@RunWith(SpringRunner.class)
public class TaskServiceTest {

    @Autowired
    private TaskService taskService;

    @MockBean
    private TaskDao taskDao;

    private Task task;

    @Test
    public void addTaskTest() {
        task = new Task(UUID.randomUUID(), "name", "text");
        Mockito.when(taskDao.insertTask(task)).thenReturn(1);

        int re = taskService.addTask(task);
        assertEquals(re, 1);
    }

    @Test
    public void getAllTasksTest() {
        List<Task> taskList = Lists.newArrayList(new Task(UUID.randomUUID(), "name", "text"), new Task(UUID.randomUUID(), "name2", "text2"));
        Mockito.when(taskDao.getAllTasks()).thenReturn(taskList);

        assertEquals(taskService.getAllTasks(), taskList);
    }

}
