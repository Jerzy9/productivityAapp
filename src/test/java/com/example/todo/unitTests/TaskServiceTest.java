package com.example.todo.unitTests;


import com.example.todo.dao.TaskDao;
import com.example.todo.model.Task;
import com.example.todo.service.TaskService;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.Assert.*;


@SpringBootTest
//@RunWith(SpringRunner.class)
public class TaskServiceTest {

    @Autowired
    private TaskService taskService;

    @MockBean
    private TaskDao taskDao;

    @Test
    public void addTaskTest_WithNameAndText() {
        Task task = new Task(UUID.randomUUID(), "name", "text");

        Mockito.when(taskDao.insertTask(task)).thenReturn(1);
        assertEquals(taskService.addTask(task), 1);
    }


    @Test
    public void getAllTasksTest() {
        List<Task> taskList = Lists.newArrayList(new Task(UUID.randomUUID(), "name", "text"), new Task(UUID.randomUUID(), "name2", "text2"));

        Mockito.when(taskDao.getAllTasks()).thenReturn(taskList);
        assertEquals(taskService.getAllTasks(), taskList);
    }

    @Test
    public void selectByIdTest_TaskFound() {
        UUID id = UUID.randomUUID();
        Task task = new Task(id, "name", "text");

        Mockito.when(taskDao.selectTaskById(id)).thenReturn(Optional.of(task));
        assertNotNull(taskService.selectById(id));
        assertEquals(taskService.selectById(id), Optional.of(task));
    }

    @Test
    public void selectByIdTest_NoSuchTask() {
        UUID id = UUID.randomUUID();

        Mockito.when(taskDao.selectTaskById(id)).thenReturn(Optional.empty());
        assertEquals(taskService.selectById(id), Optional.empty());
    }

    @Test
    public void deleteTaskTest() {
        UUID id = UUID.randomUUID();

        Mockito.when(taskDao.deleteTask(id)).thenReturn(1);
        assertEquals(taskService.deleteTask(id), 1);
    }

    @Test
    public void getLatestTask() {
        Task task = new Task(UUID.randomUUID(), "name", "test");

        Mockito.when(taskDao.getLastTask()).thenReturn(task);
        assertEquals(taskService.getLatestTask(), task);
    }


}
