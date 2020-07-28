package com.example.todo.automatic.tests;

import java.util.Random;

public class AddTask {
    private String name;
    private String text;
    private Random r = new Random();

    private final String ALPHA_NUMERIC_STRING = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public AddTask() {
        System.out.println(randomStringGenerator());
    }
    public void addTask() {

    }
    public String randomStringGenerator() {
        StringBuilder randomString = new StringBuilder();
        int length = 16;

        System.out.println(ALPHA_NUMERIC_STRING.length());
        for (int i = 0; i < length; i++) {
            randomString.append(ALPHA_NUMERIC_STRING.charAt(r.nextInt(ALPHA_NUMERIC_STRING.length())));
        }

        return randomString.toString();
    }
}
