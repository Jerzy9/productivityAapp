package com.example.todo.unitTests;

import com.example.todo.dao.TaskDao;
import com.example.todo.model.Task;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;

import java.util.UUID;

import static org.junit.Assert.*;

@SpringBootTest
public class TaskDaoInterfaceTest {

    @SpyBean
    TaskDao taskDao;

    @Test
    public void insertTaskDefaultTest() {
        Task task = new Task(UUID.randomUUID(), "name", "text");

        Mockito.when(taskDao.insertTask(UUID.randomUUID(), task)).thenReturn(1);
        assertEquals(taskDao.insertTask(task), 1);


    }
}
