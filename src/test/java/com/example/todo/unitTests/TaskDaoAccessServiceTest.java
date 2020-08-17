package com.example.todo.unitTests;

import com.example.todo.dao.TaskDao;
import com.example.todo.dao.TaskDaoAccessService;
import com.example.todo.model.Task;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class TaskDaoAccessServiceTest {

    @Autowired
    private TaskDaoAccessService dao;

    @Test
    public void whenGetAllTasks_thenReturnListOfAllTasks() {
        System.out.println(UUID.randomUUID());
        List<Task> daoList = dao.getAllTasks();
        assertEquals(daoList, null);

    }

    @Test
    public void insertTest() {
        UUID id = UUID.randomUUID();
        Task task = new Task(id, "name", "test");
        assertEquals(1, dao.insertTask(UUID.randomUUID(),task));
    }

    @Test
    public void autowiredTest() {
        assertNull(dao);
    }

//    @Test
//    public
}
