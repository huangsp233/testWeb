package com.web.page;

import com.web.util.ProUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class BasePage {
    public WebDriver driver;
    public ProUtil proUtil;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    /**
    * 获取元素
    */
    public WebElement GetElement(String key) {
        WebElement element;
        element = driver.findElement(this.GetByLocal(key));
        return element;

    }

    /*
     * 获取元素list
     */
    public List<WebElement> GetElements(String key) {
        List<WebElement> elements;
        elements = driver.findElements(this.GetByLocal(key));
        return elements;
    }

    public By GetByLocal(String key) {
        System.out.println("key----------"+key);
        proUtil = new ProUtil("element.properties");
        String Locator = proUtil.getString(key);
        System.out.println("------------:"+Locator);
        String locatorBy = Locator.split(">")[0];
        String LocatorValue = Locator.split(">")[1];

        if(locatorBy.equals("id")) {
            return By.id(LocatorValue);
        }else if(locatorBy.equals("name")) {
            return By.name(LocatorValue);
        }else if(locatorBy.equals("className")) {
            return By.className(LocatorValue);
        }else {
            return By.xpath(LocatorValue);
        }
    }

    /*
    * 移动至某元素
    */
    public void MoveToElement(WebElement toElement) {
        Actions MoseActions = new Actions(driver);
        MoseActions.moveToElement(toElement).perform();
    }

    /*
     * 右键某元素
     */
    public void RightKeyElement(WebElement element) {
        Actions MoseActions = new Actions(driver);
        MoseActions.contextClick(element).perform();
    }



}