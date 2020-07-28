package com.example.todo.automatic.tests;

public class TestController {

    private AddTask add;
    private StartWebBrowser browser;

    public TestController() {

        add = new AddTask();

        addTask();
    }

    //Add task
    public void addTask() {
        browser.startAndSearch();
        add.randomStringGenerator();
    }
}
