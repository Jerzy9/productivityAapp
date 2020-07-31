package com.example.todo.automatic.tests.src.pages;

import com.example.todo.automatic.tests.src.config.SeleniumConfig;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AddTaskPage {

    private SeleniumConfig config;

    @FindBy(css = "#add-button")
    private WebElement showHideBtn;

    public AddTaskPage(SeleniumConfig config) {
        this.config = config;
        PageFactory.initElements(this.config.getDriver(), this);
        config.waitDriver();
    }

    public void clickOnAddTask() {
        config.clickElement(showHideBtn);
        config.waitDriver();
    }

}