package com.web.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//登陆页面元素获取
public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //获取登陆页面元素
    public WebElement GetEmailElement() {
        return GetElement("username");
    }

    public WebElement GetPasswordElement() {
        return GetElement("password");
    }

    public WebElement GetLoginButtonElement() {
        return GetElement("loginbutton");
    }

    public WebElement GetUsePngElement() {
        return GetElement("headpng");
    }

    public WebElement GetUseInfoElement() {
        return GetElement("userinfo");
    }

    public WebElement GetSigninButtonElement() {
        System.out.println(GetElement("signin_button").getText());
        return GetElement("signin_button");
    }

    public WebElement GetSigninElement() {
        WebElement signin  = GetElement("signin");
        System.out.println("signin-------"+signin);
        return GetElement("signin");
    }

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        LoginPage loginPage = new LoginPage(driver);
        System.out.println(loginPage.GetSigninButtonElement().getText());
    }


}