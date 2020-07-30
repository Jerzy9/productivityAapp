package com.example.todo.automatic.tests.src.pages;

import com.example.todo.automatic.tests.src.config.SeleniumConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddTaskPage {

    private SeleniumConfig config;
    private WebDriver driver;

    private final String homePageUrl = "http://localhost:8080";

    @FindBy(css = "#add-button")
    private WebElement showHideBtn;

    public AddTaskPage() {
        config = new SeleniumConfig();
        driver = config.getDriver();
        config.navigateTo(homePageUrl);
    }

    public TaskHomePage clickOnAddTask() {
//        showHideBtn = driver.findElement(By.cssSelector("#add-button"));
        config.clickElement(showHideBtn);
        config.waitDriver();
        return new TaskHomePage(driver, config);
    }
}
