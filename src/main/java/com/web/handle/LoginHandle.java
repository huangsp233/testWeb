package com.web.handle;


import com.web.page.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class LoginHandle extends BaseHandle{
	public LoginPage loginpage;
	public LoginHandle(WebDriver driver) {
		super(driver);
		loginpage = new LoginPage(driver);
	}
	public void SendEmail(String email) {
		WebElement EmailElement = loginpage.GetEmailElement();
		ClearText(EmailElement);	
		EmailElement.sendKeys(email);
		
	}
	
	public void SendPassword(String password) {
		WebElement PassworElement = loginpage.GetPasswordElement();
		ClearText(PassworElement);
		PassworElement.sendKeys(password);
	}

	public void ClickLogin() {
		loginpage.GetLoginButtonElement().click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public String GetUserText() {
		loginpage.MoveToElement(loginpage.GetUsePngElement());
		String username = loginpage.GetUseInfoElement().getText();
		return username;
	}
	
	public void ClickSigninButton() {
		loginpage.GetSigninButtonElement().click();
	}

	public void ClickSignin() {
		loginpage.GetSigninElement().click();
	}

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "E:\\chrome\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://10.8.32.103:8090/login?toUrl=http%3A%2F%2F10.8.32.103%3A8090%2Flogin");
		LoginHandle loginHandle = new LoginHandle(driver);
//		loginHandle.ClickSigninButton();
		loginHandle.ClickSignin();
	}

}
