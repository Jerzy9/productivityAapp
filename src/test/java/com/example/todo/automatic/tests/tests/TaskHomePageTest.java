package com.example.todo.automatic.tests.tests;

import com.example.todo.automatic.tests.src.config.SeleniumConfig;
import com.example.todo.automatic.tests.src.pages.TaskHomePage;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;


//@RunWith(JUnit4.class)
public class TaskHomePageTest {

    private static SeleniumConfig config = new SeleniumConfig();;
    private TaskHomePage homePage = new TaskHomePage(config);
    @BeforeClass
    public static void setup() {
        //doesn't work
        System.out.println("does work");
    }

    @Test
    public void givenAddTaskBtn_whenIsClicked_thenShowTaskForm() {
        homePage.clickOnAddTask();

        assertTrue(homePage.isFormShown());
    }

    @Test
    public void givenTaskFrom_whenInsertNameTextAndSubmit_thenTaskAdded() {
        String name = config.randomStringGenerator(10);
        String text = config.randomStringGenerator(32);

        if(!homePage.isFormShown()) {
            homePage.clickOnAddTask();
        }
        homePage.addTask(name, text);
        homePage.clickOnAddTask();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            ex.fillInStackTrace();
        }

        assertEquals(homePage.getLatestTaskName(), name);
        assertEquals(homePage.getLatestTaskText(), text);
    }

    @Test
    public void givenTaskFrom_whenInsertOnlyNameAndSubmit_thenTaskAdded() {
        String name = config.randomStringGenerator(10);

        if(!homePage.isFormShown()) {
            homePage.clickOnAddTask();
        }
        homePage.addTask(name, null);
        homePage.clickOnAddTask();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            ex.fillInStackTrace();
        }
        System.out.println(homePage.getLatestTaskName());
        assertEquals(homePage.getLatestTaskName(), name);
        assertEquals(homePage.getLatestTaskText(), "<>");
    }
}
