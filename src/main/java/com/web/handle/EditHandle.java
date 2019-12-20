package com.web.handle;

import com.web.page.EditPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class EditHandle extends BaseHandle {
    public WebDriver driver;
    public EditPage editPage;
    public EditHandle(WebDriver driver) {
        super(driver);
        this.driver = driver;
        editPage = new EditPage(driver);
    }

    public Boolean HasPreviewBtn(){
        Boolean flag =false;
        if(editPage.GetPreviewBtn() != null){
            return true;
        }
        return flag;
    }

    /**
     * 移动鼠标到登录按钮
     * */
    public void MoveToChartBtn(String key) {
        //获取图表新增按钮
        WebElement chartBtn = editPage.GetElement(key);
        editPage.MoveToElement(chartBtn);
    }

    /**
     * 获取左侧图层组件list
     * */
    public List<WebElement> GetLeftCompTree(String key) {
        List<WebElement> elements = editPage.GetElements(key);
        return elements;
    }

    /**
     * 获取新增组件的tool button集
     * */
    public List<WebElement> GetToolEles(String key) {
        List<WebElement> elements = editPage.GetElements(key);
        return elements;
    }

    /**
     * 获取新增组件选择框内组件集
     * */
    public List<WebElement> GetLockCharts(String key) {
        List<WebElement> elements = editPage.GetElements(key);
        return elements;
    }

    /**
     * 移动鼠标到要新增的组件上
     * */
    public void MoveToLockChart(WebElement element) {
        editPage.MoveToElement(element);
    }

    /**
     * 点击新增组件按钮
     * */
    public void ClickAddCompBtn(String key) {
        super.ClickElement(editPage.GetElement(key));
    }

    /**
     * 右键所要复制的组件
     * */
    public void RightKeyChart(WebElement element) {
        editPage.RightKeyElement(element);
    }
    /**
     * 点击复制项
     * */
    public void ClickCopyCompBtn(String key, int idx) {
        super.ClickElement(editPage.GetElements(key).get(idx));
    }

    /**
     * 点击删除确认按钮
     * */
    public void DelConfirmBtn(String key) {
        super.ClickElement(editPage.GetElement(key));
    }
    /**
     * 获取重命名输入框
     * */
    public WebElement GetRenameBtn(String key) {
        return editPage.GetElement(key);
    }

    /**
     * 组件重命名
     * */
    public void RenameComp(WebElement ele) {
        String compTitle = ele.getAttribute("value");
        //将原标题删除并重命名
        if(compTitle !=null){
            for (int i = 0;i<compTitle.length();i++){
                ele.sendKeys(Keys.BACK_SPACE);
            }
            ele.sendKeys("test");
        }
    }
    /**
     * 获取指定位置组件id
     * */
    public String GetCompId(List<WebElement> startComponents, int idx) {
        return startComponents.get(idx).getAttribute("id");

    }
}