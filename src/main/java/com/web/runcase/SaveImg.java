package com.web.runcase;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class SaveImg {
    private static WebDriver driver;
    private static String baseUrl;

    public static void testDownload() throws Exception {
    	baseUrl = "https://www.imooc.com/";

        System.setProperty("webdriver.chrome.driver", "E:\\chrome\\chromedriver.exe");
 		driver = new ChromeDriver();
 		driver.get(baseUrl);
 		 try {
             Thread.sleep(2000);
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
    	WebElement image = driver.findElements(By.className("course-banner")).get(0);
    	Actions action = new Actions(driver);
    	action.contextClick(image).perform();
        try {
        
            Robot robot = new Robot();
            for(int i = 0; i<8;i++){
                robot.keyPress(KeyEvent.VK_DOWN);
                Thread.sleep(1000);
            }
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        //图片地址存放路径
        String imgPath = System.getProperty("user.dir")+File.separator+"img"+File.separator+"test1.png";
        //识别text存放路径
        String txtPath = System.getProperty("user.dir")+File.separator+"img"+File.separator+"test2";
        System.out.println("path:---------"+imgPath);
        //将地址放入剪贴板
        StringSelection stringSelection = new StringSelection(imgPath);
		Clipboard systemClipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		systemClipboard.setContents(stringSelection, null);
		
		//使用robot进行地址粘贴--完成图片保存在指定目录下
		Robot robot;
		try {
			robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
		
		
		try {
		    Runtime.getRuntime().exec(new String[]{"E:\\tesseract\\Tesseract-OCR\\tesseract.exe",
            		imgPath, txtPath});
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

   public static void main(String[] args) {
	   try {
		testDownload();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}