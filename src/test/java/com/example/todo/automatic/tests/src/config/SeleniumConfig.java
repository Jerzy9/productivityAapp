package com.example.todo.automatic.tests.src.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class SeleniumConfig {

    private final Random r = new Random();
    private final String ALPHA_NUMERIC_STRING = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789 ";
    private WebDriver driver;
    private final String pageUrl = "http://localhost:8080";


    public SeleniumConfig() {
        System.setProperty("webdriver.chrome.driver", "D:\\Web Drivers\\chrome\\chromedriver84.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        navigateTo();
        waitDriver();
    }

    public void close() {
        driver.close();
    }

    public void navigateTo() {
        driver.get(pageUrl);
        waitDriver();
    }

    public void clickElement(WebElement element) {
        element.click();
        waitDriver();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public String randomStringGenerator(int length) {
        StringBuilder randomString = new StringBuilder();

        for (int i = 0; i < length; i++) {
            randomString.append(ALPHA_NUMERIC_STRING.charAt(r.nextInt(ALPHA_NUMERIC_STRING.length())));
        }
        return randomString.toString();
    }

    public String randomStringGenerator() {
        return randomStringGenerator(16);
    }

    public void waitDriver() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    }

}
