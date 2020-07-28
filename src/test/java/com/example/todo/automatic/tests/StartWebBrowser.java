package com.example.todo.automatic.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class StartWebBrowser {
    private WebDriver driver;

    public StartWebBrowser() {
        //set property
        System.setProperty("webdriver.chrome.driver", "D:\\Web Drivers\\chrome\\chromedriver84.exe");
        driver = new ChromeDriver();
        startAndSearch();
    }

    public WebDriver startAndSearch() {
        driver.get("http://localhost:8080");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        return driver;
    }

}
