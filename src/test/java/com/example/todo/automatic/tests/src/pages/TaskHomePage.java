package com.example.todo.automatic.tests.src.pages;

import com.example.todo.automatic.tests.src.config.SeleniumConfig;
import com.example.todo.model.Task;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TaskHomePage {

    private SeleniumConfig config;

    @FindBy(id = "add-task")
    private WebElement showHideBtn;
    @FindBy(id = "name-input")
    private WebElement nameInput;
    @FindBy(id = "text-area")
    private WebElement textInput;
    @FindBy(id = "submit-btn")
    private WebElement submitFormBtn;

    public TaskHomePage(SeleniumConfig config) {
        this.config = config;

        PageFactory.initElements(this.config.getDriver(), this);
        config.waitDriver();
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
