package com.web.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EditPage extends BasePage {
    public WebDriver driver;

    public EditPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    /**
    * 获取预览button
    */
    public WebElement GetPreviewBtn() {
        return GetElement("previewBtn");
    }
}