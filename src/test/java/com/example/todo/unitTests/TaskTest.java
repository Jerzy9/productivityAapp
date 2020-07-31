package com.example.todo.unitTests;

import com.example.todo.model.Task;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;
import static org.junit.Assert.*;


@SpringBootTest
public class TaskTest {

    private Task task;

    @Test
    public void taskConstructorAndGettersTest() {
        UUID id = UUID.randomUUID();
        String name = "name";
        String text = "text";

        task = new Task(id, name, text);

        assertEquals(task.getId(), id);
        assertEquals(task.getName(), name);
        assertEquals(task.getText(), text);
    }
}
