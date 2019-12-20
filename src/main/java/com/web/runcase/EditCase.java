package com.web.runcase;

import com.web.handle.EditHandle;
import com.web.page.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

public class EditCase extends BaseCase{
    public static WebDriver driver;
    public EditHandle editHandle;
    public List<WebElement> startComponents;
    @Parameters({"url","browser","username","password","editPage"})
    @BeforeClass
    public void beforeClass(String url,String browser,String username,String password,String editPage) {
        //beforeclass执行登陆操作，输入用户名密码，点击登陆，保持登陆状态
        driver = GetDriver(browser);
        driver.get(url);
        editHandle = new EditHandle(driver);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //设置用户名
        editHandle.setUserName(username);
        //设置密码
        editHandle.setPassword(password);
        //点击登陆
        editHandle.clickLoginBtn();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //跳转到编辑页
        driver.get(editPage);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    /*
     * 等待2s+获取初始时左侧组件列表
     */
    @BeforeTest
    public void WaitCase(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    /*
     * 新增组件
     */
    @Test
    public void AddComponetCase(){
        //未新增之前统计左侧树组件个数
        startComponents = editHandle.GetLeftCompTree("leftCompTree");
        List<WebElement> toolEles = editHandle.GetToolEles("toolEles");
        //点击图表按钮
        toolEles.get(0).click();

        //获得新增按钮 --工具行第一个
        toolEles.get(1).click();
        //鼠标悬浮在基本曲线图组件上，点击新增按钮
        List<WebElement> charts = editHandle.GetLockCharts("lockChart");
        //鼠标悬浮要新增的组件
        editHandle.MoveToLockChart(charts.get(0));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //点击新增按钮
        editHandle.ClickAddCompBtn("addLockChartBtn");
        //检验左侧图层组件数是否加一
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //新增操作后左侧树组件列表
        List<WebElement> endComponents = editHandle.GetLeftCompTree("leftCompTree");
        Assert.assertEquals(endComponents.size()-startComponents.size(),1);
    }



    /*
     * 复制组件
     */
    @Test
    public void CopyComponetCase(){
        //未新增之前统计左侧树组件个数
        startComponents = editHandle.GetLeftCompTree("leftCompTree");
        //树组件第一个组件--鼠标右键--在弹框中选中复制功能
        editHandle.RightKeyChart(startComponents.get(0));
        //点击右键中复制项
        editHandle.ClickCopyCompBtn("rightMemu",9);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //复制操作后左侧树组件列表
        List<WebElement> endComponents = editHandle.GetLeftCompTree("leftCompTree");
        Assert.assertEquals(endComponents.size()-startComponents.size(),1);
    }


    /*
     * 删除组件
     */
    @Test
    public void DelComponetCase(){
        //未新增之前统计左侧树组件个数
        startComponents = editHandle.GetLeftCompTree("leftCompTree");
        //树组件第一个组件--鼠标右键--在弹框中选中删除功能
        editHandle.RightKeyChart(startComponents.get(0));
        //点击右键中删除项
        editHandle.ClickCopyCompBtn("rightMemu",11);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //点击确认弹框--获取弹框中的确认按钮点击
        editHandle.DelConfirmBtn("delComfirm");
        //删除操作后左侧树组件列表
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<WebElement> endComponents = editHandle.GetLeftCompTree("leftCompTree");
        Assert.assertEquals(endComponents.size()-startComponents.size(),-1);
    }

    /*
     * 重命名组件
     */
    @Test
    public void RenameComponetCase(){
        //未新增之前统计左侧树组件个数
        startComponents = editHandle.GetLeftCompTree("leftCompTree");
        //树组件第一个组件--鼠标右键--在弹框中选中重命名功能
        editHandle.RightKeyChart(startComponents.get(0));
        //点击右键中重命名项
        editHandle.ClickCopyCompBtn("rightMemu",8);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //获取命名输入框
        WebElement ele = editHandle.GetRenameBtn("renameInp");
        //组件重命名
        editHandle.RenameComp(ele);
        //校验组件是否命名成功
        Assert.assertEquals(ele.getAttribute("value"),"test");
    }

    /*
     * 组件下移功能
     */
    @Test
    public void MoveToNextCase(){
        //未新增之前统计左侧树组件个数
        startComponents = editHandle.GetLeftCompTree("leftCompTree");
        //树组件第一个组件--鼠标右键--在弹框中选中下移一层功能
        editHandle.RightKeyChart(startComponents.get(0));
        //获取指定位置组件id
        String startCompId = editHandle.GetCompId(startComponents,0);
        //获取第一个组件的id
        System.out.println("first id :    "+ startCompId);
        //点击右键中下移一层项
        editHandle.ClickCopyCompBtn("rightMemu",3);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //组件个数多于两个--操作完成后校验第二个组件id，组件个数==1则校验第一个组件id；通过组件id判断是否下移成功
        if(startComponents.size()>1){
            startComponents = editHandle.GetLeftCompTree("leftCompTree");
            String endCompId = editHandle.GetCompId(startComponents,1);
            System.out.println("endCompId:   "+endCompId);
            Assert.assertEquals(endCompId,startCompId);
        }

    }

}