package com.web.runcase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseCase {
    public WebDriver driver;
    public WebDriver GetDriver(String browser) {

        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "E:\\chrome\\chromedriver.exe");
            driver = new ChromeDriver();
        }
        return driver;
    }

    public String GetVerifiedCode(){
        String veriCode ="";
        //


        return veriCode;
    }
}