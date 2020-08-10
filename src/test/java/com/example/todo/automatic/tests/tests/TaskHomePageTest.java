package com.example.todo.automatic.tests.tests;

import com.example.todo.automatic.tests.src.config.SeleniumConfig;
import com.example.todo.automatic.tests.src.pages.TaskHomePage;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.NoSuchElementException;


//@RunWith(JUnit4.class)
public class TaskHomePageTest {

    private static SeleniumConfig config = new SeleniumConfig();;
    private TaskHomePage homePage = new TaskHomePage(config);
    @BeforeClass
    public static void setup() {
        //doesn't work
        System.out.println("does work");
    }

    private void openFormIfClosed() {
        if(!homePage.isFormShown()) {
            homePage.clickOnAddTask();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.fillInStackTrace();
        }
    }
    @Test
    public void givenAddTaskBtn_whenIsClicked_thenShowTaskForm() {
        openFormIfClosed();

        assertTrue(homePage.isFormShown());
    }

    @Test
    public void givenTaskFrom_whenInsertNameTextAndSubmit_thenTaskAdded() {
        String name = config.randomStringGenerator(10);
        String text = config.randomStringGenerator(32);

        openFormIfClosed();
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

        openFormIfClosed();
        homePage.addTask(name, null);
        homePage.clickOnAddTask();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            ex.fillInStackTrace();
        }

        assertEquals(homePage.getLatestTaskName(), name);
        try {
            assertNull(homePage.getLatestTaskText());
        } catch (NoSuchElementException ex) {
            assertThrows(NoSuchElementException.class, () -> {
                homePage.getLatestTaskText();
            });
        }
    }

    @Test
    public void givenTask_whenPressedBinTask_thenDeleteTask() {
        String name = config.randomStringGenerator(10);
        String text = config.randomStringGenerator(52);

        openFormIfClosed();

        homePage.addTask(name, text);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            ex.fillInStackTrace();
        }

        assertEquals(homePage.getLatestTaskName(), name);
        assertEquals(homePage.getLatestTaskText(), text);

        homePage.clickOnLatestTaskBinBtn();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            ex.fillInStackTrace();
        }

        try {
            assertNotEquals(homePage.getLatestTaskName(), name);
        } catch (NoSuchElementException ex) {
            assertThrows(NoSuchElementException.class, () -> {
                homePage.getLatestTaskName();
            });
        }

        try {
            assertNotEquals(homePage.getLatestTaskText(), text);
        } catch (NoSuchElementException ex) {
            assertThrows(NoSuchElementException.class, () -> {
                homePage.getLatestTaskText();
            });
        }
    }
}
