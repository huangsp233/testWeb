package com.web.handle;

import com.web.page.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BaseHandle {
	public WebDriver driver;
	public BasePage basePage;
	public BaseHandle(WebDriver driver) {
		this.driver = driver;
		basePage = new BasePage(driver);
	}

	public void ClearText(WebElement element) {
		/**
		 * 		清空输入框
		 * */
		element.clear();
	}
	
	/**
	 * 获取title
	 * */
	public String GetTitle() {
		return driver.getTitle();
	}

	
	public void ClickElement(WebElement element) {
		element.click();
	}

	/**
	 * 设置用户名
	 * */
	public void setUserName(String username) {
		//获取用户名元素
		WebElement usernameEle = basePage.GetElement("username");
		//设置用户名
		usernameEle.sendKeys(username);
	}

	/**
	 * 设置密码
	 * */
	public void setPassword(String password) {
		//获取用户名元素
		WebElement usernameEle = basePage.GetElement("password");
		//设置用户名
		usernameEle.sendKeys(password);
	}

	/**
	 * 点击登陆按钮
	 * */
	public void clickLoginBtn() {
		//获取登陆按钮并且点击
		basePage.GetElement("loginbutton").click();
	}

}
