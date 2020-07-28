package com.example.todo.automatic.tests;

import org.openqa.selenium.WebDriver;

public class TestController {

    private AddTask add;
    private StartWebBrowser browser;
    private WebDriver webDriver;

    public TestController() {
        browser = new StartWebBrowser();
        webDriver = browser.startAndSearch();
        add = new AddTask(webDriver);

        addTask();
    }

    //Add task
    public void addTask() {
        browser.startAndSearch();
        add.randomStringGenerator();
    }
}
