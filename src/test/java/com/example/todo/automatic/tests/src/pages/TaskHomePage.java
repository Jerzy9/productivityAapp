package com.example.todo.automatic.tests.src.pages;

import com.example.todo.automatic.tests.src.config.SeleniumConfig;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TaskHomePage {

    private SeleniumConfig config;

    @FindBy(css = "#add-button")
    private WebElement showHideBtn;
    @FindBy(id = "name-input")
    private WebElement nameInput;
    @FindBy(id = "text-area")
    private WebElement textInput;
    @FindBy(id = "submit-btn")
    private WebElement submitFormBtn;

    @FindBy(xpath = "//*[@id=\"all-tasks\"]/div/div[1]/div/div/p")
    private WebElement latestTaskName;
    @FindBy(xpath = "//*[@id=\"all-tasks\"]/div/div[2]/div/div/p")
    private WebElement latestTaskText;
    @FindBy(xpath = "//*[@id=\"all-tasks\"]/div[1]/div[1]/div/div[2]/button")
    private WebElement latestTaskBinBtn;





    public TaskHomePage(SeleniumConfig config) {
        this.config = config;

        PageFactory.initElements(this.config.getDriver(), this);
        config.waitDriver();
    }

    public String getLatestTaskName() throws NoSuchElementException {
        return latestTaskName.getText();
    }
    public String getLatestTaskText() {
        return latestTaskText.getText();
    }

    public boolean isFormShown() {
        return showHideBtn.getText().equals("Hide form");
    }

    public void addTask(String name, String text) {
        fillNameInput(name);
        fillTextInput(text);
        clickOnSubmit();
        refreshData();

    }
    public void fillNameInput(String name) {
        if(name != null && !name.equals("")) {
            nameInput.sendKeys(name);
            config.waitDriver();
        }
    }
    public void fillTextInput(String text) {
        if(text != null && !text.equals("")) {
            textInput.sendKeys(text);
            config.waitDriver();
        }
    }
    public void clickOnSubmit() {
        submitFormBtn.click();
        config.waitDriver();
    }
    public void clickOnAddTask() {
        config.clickElement(showHideBtn);
        config.waitDriver();
        refreshData();
    }
    public void refreshData() {
        PageFactory.initElements(this.config.getDriver(), this);
        config.waitDriver();
    }
    public void clickOnLatestTaskBinBtn() {
        config.clickElement(latestTaskBinBtn);
        config.waitDriver();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            ex.fillInStackTrace();
        }
        refreshData();
    }

}
