package com.example.todo.automatic.tests.tests;

import com.example.todo.automatic.tests.src.pages.AddTaskPage;
import com.example.todo.automatic.tests.src.pages.TaskHomePage;
import org.junit.Before;
import org.junit.jupiter.api.Test;

public class TaskHomePageTest {

    private TaskHomePage homePage;

//    @Before
//    public void adsd() {
//
//    }

    @Test
    public void StartHomePage() {
        AddTaskPage addPage = new AddTaskPage();
        addPage.clickOnAddTask();

    }
}
