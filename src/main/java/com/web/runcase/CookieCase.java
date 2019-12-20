package com.web.runcase;

import com.web.page.BasePage;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Set;

public class CookieCase {

    public static WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "E:\\chrome\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://10.8.32.103:8090/login?toUrl=http%3A%2F%2F10.8.32.103%3A8090%2Flogin");

    }

    @AfterClass
    public void afterClass() {

    }
    //判断当前是否登录 --key :JSESSIONID
    public boolean GetCookie(String domain) {
        boolean flag = false;
        Set<Cookie> cookies = driver.manage().getCookies();
        for(Cookie cookie:cookies) {
            if(cookie.getDomain()!="" && cookie.getDomain().equals(domain)){
                flag = true;
            }
//            if(cookie.getName().equals(key)) {
//                flag = true;
//            }
        }
        return flag;
    }

    //设置cookie
    public void  SetUserCookie() {
        String value ="3F57A7E6C1F8760BECF23E91DCA43A31";
        driver.manage().deleteAllCookies();
        Cookie cookie = new Cookie("JSESSIONID",value,"10.8.32.103","/",null);
        driver.manage().addCookie(cookie);
    }


    @Test
    public void TestLoginSucess() {
        //判断是否登录，未登录则植入cookie 并跳转到大屏页面
//        System.out.println(GetCookie("10.8.32.103"));
//        if(!GetCookie("10.8.32.103")){
//            //未登录，植入cookie
//            SetUserCookie();
//        }
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        driver.navigate().refresh();
        //进行页面登陆，登陆完成后从driver中获取session
        BasePage basePage = new BasePage(driver);
        //输入用户名,密码，并点击登陆
        basePage.GetElement("username").sendKeys("huangsp1");
        basePage.GetElement("password").sendKeys("1");
        basePage.GetElement("loginbutton").click();
        //登陆后获取session
        System.out.println(driver.manage().getCookies());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.get("http://10.8.32.103:8090/screen/651868037883887616?workspaceId=606802768258138112&backRouterName=PROJECT");

    }
}