package com.example.todo.automatic.tests.tests;

import com.example.todo.automatic.tests.src.config.SeleniumConfig;
import com.example.todo.automatic.tests.src.pages.AddTaskPage;
import com.example.todo.automatic.tests.src.pages.TaskHomePage;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;


//@RunWith(JUnit4.class)
public class TaskHomePageTest {
    private static SeleniumConfig config = new SeleniumConfig();;

    @BeforeClass
    public static void setup() {
        //doesn't work
        System.out.println("does work");
    }

    @Test
    public void StartHomePage() {

        AddTaskPage addTaskPage = new AddTaskPage(config);
        addTaskPage.clickOnAddTask();

    }

    @Test
    public void addTaskWithNameAndText() {
        TaskHomePage homePage = new TaskHomePage(config);
        homePage.addTask("pierwsze zadanie", "opis");

    }
}
