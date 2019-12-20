package com.web.runcase;

import com.web.handle.LoginHandle;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginCase extends BaseCase {

    public static WebDriver driver;
    LoginHandle loginhandle;

    @BeforeClass
    public void beforeClass() {
        driver = GetDriver("chrome" );
        driver.get("https://www.imooc.com/");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }

    @AfterClass
    public void afterClass() {
        driver.close();
    }


    @Test
    public void TestLoginSucess() {
        loginhandle = new LoginHandle(driver);
        loginhandle.ClickSigninButton();
        loginhandle.SendEmail("username");
        loginhandle.SendPassword("password");
        loginhandle.ClickLogin();
        String username1 = loginhandle.GetUserText();
        Assert.assertEquals(username1, "test");

    }

//    @Parameters({"username","password"})
//    public void TestLoginEmailError(String username,String password) {
//        loginhandle.SendEmail(username);
//        loginhandle.SendPassword(password);
//        //loginhandle.ClickSenvenBox();
//        loginhandle.ClickLogin();
//        String username1 = loginhandle.GetUserText();
//        Assert.assertEquals(username1, "test2");
//    }
}