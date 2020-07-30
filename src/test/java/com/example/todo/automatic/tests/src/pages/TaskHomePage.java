package com.example.todo.automatic.tests.src.pages;

import com.example.todo.automatic.tests.src.config.SeleniumConfig;
import com.example.todo.model.Task;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TaskHomePage {

    private SeleniumConfig config;
    private WebDriver driver;

    private final String homePageUrl = "http://localhost:8080";

//    @FindBy(id = "add-task")
//    private WebElement showHideBtn;
    @FindBy(id = "name-input")
    private WebElement nameInput;
    @FindBy(id = "text-area")
    private WebElement textInput;
    @FindBy(id = "submit-btn")
    private WebElement submitFormBtn;

    public TaskHomePage(WebDriver driver, SeleniumConfig config) {
        this.driver = driver;
        this.config = config;

    }


    public void addTask(String name, String text) {
        fillNameInput(name);
        fillTextInput(text);
        clickOnSubmit();
    }
    public void fillNameInput(String name) {
        nameInput.sendKeys(name);
        config.waitDriver();
    }
    public void fillTextInput(String text) {
        textInput.sendKeys(text);
        config.waitDriver();
    }
    public void clickOnSubmit() {
        submitFormBtn.click();
        config.waitDriver();
    }


}
