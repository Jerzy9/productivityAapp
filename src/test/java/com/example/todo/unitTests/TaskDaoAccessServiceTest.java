package com.example.todo.unitTests;

import com.example.todo.dao.TaskDao;
import com.example.todo.dao.TaskDaoAccessService;
import com.example.todo.model.Task;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.Assert.*;

import java.util.List;
import java.util.UUID;

@SpringBootTest
public class TaskDaoAccessServiceTest {

    @Autowired
    private TaskDaoAccessService dao;

    @Test
    public void daoAutowiredTest() {
        assertNotNull(dao);
    }

    @Test
    public void getAllTasksTest() {
        List<Task> daoList = dao.getAllTasks();

        System.out.println(daoList.get(0).getId());
        System.out.println(daoList.get(0).getName());
        System.out.println(daoList.get(0).getText());

        assertNotNull(daoList.get(0).getId());
        assertNotNull(daoList.get(0).getName());
        assertNotNull(daoList.get(0).getText());
    }

    @Test
    public void insertTaskTest() {
        UUID id = UUID.randomUUID();
        Task task = new Task(id, "name", "test");
        assertEquals(1, dao.insertTask(UUID.randomUUID(),task));
    }

    @Test
    public void getTaskByIdTest() {
        UUID id = UUID.randomUUID();
        String name = "name";
        String text = "text";

        Task task = new Task(id, name, text);
        dao.insertTask(id, task);

        assertEquals(id, dao.selectTaskById(id).get().getId());
        assertEquals(name, dao.selectTaskById(id).get().getName());
        assertEquals(text, dao.selectTaskById(id).get().getText());
    }

    @Test
    public void deleteTest() {
        UUID id = UUID.randomUUID();
        Task task = new Task(id, "name", "test");

        assertEquals(1, dao.insertTask(id, task));
        assertEquals(1, dao.deleteTask(id));
    }

    @Test
    public void getLastTaskTest() {
        UUID id = UUID.randomUUID();
        Task task = new Task(id, "name", "test");
//        dao.insertTask(UUID.randomUUID(),task)
//        assertEquals(1, );
//
//        assertEquals(id, dao.getLastTask().getId());
    }



}
