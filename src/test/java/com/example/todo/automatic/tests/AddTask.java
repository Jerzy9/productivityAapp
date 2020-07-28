package com.example.todo.automatic.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Random;

public class AddTask {
    private WebDriver webDriver;

    private String name;
    private String text;
    private Random r = new Random();

    private final String ALPHA_NUMERIC_STRING = " abcdefghijklmnopqrstuvwxyz ABCDEFGHIJKLMNOPQRSTUVWXYZ 0123456789 ";

    public AddTask(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    public void addTaskWithNameAndText() {
        webDriver.findElement(By.id("add-button")).click();


    }
    public void addTask() {

    }
    public String randomStringGenerator(int length) {
        StringBuilder randomString = new StringBuilder();

        System.out.println(ALPHA_NUMERIC_STRING.length());
        for (int i = 0; i < length; i++) {
            randomString.append(ALPHA_NUMERIC_STRING.charAt(r.nextInt(ALPHA_NUMERIC_STRING.length())));
        }
        return randomString.toString();
    }
    public String randomStringGenerator() {
       return randomStringGenerator(16);
    }
}
