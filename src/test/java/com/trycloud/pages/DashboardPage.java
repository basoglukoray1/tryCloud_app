package com.trycloud.pages;

import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {

    public DashboardPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

/*
 public void navigateToModule(String tab, String module){

        String tabLocator = "//span[normalize-space()='" + tab + "' and contains(@class, 'title title-level-1')]";
        String moduleLocator = "//span[normalize-space()='" + module + "' and contains(@class, 'title title-level-2')]";
 */

    public void navigateToTab(String tab){

        WebElement elementTab=Driver.getDriver().findElement(By.xpath("//ul[@id='appmenu']//li[normalize-space()='"+tab+"']")) ;
        BrowserUtils.highlight(elementTab);
        elementTab.click();
        BrowserUtils.waitForPageToLoad(5);

    }
/*
public static void clickSubModule(String module){

        WebElement element = Driver.getDriver().findElement(By.xpath("//div[@id='app-navigation']//*[normalize-space(.)='"+module+"']"));
        BrowserUtils.highlight(element);
        element.click();
        BrowserUtils.waitForPageToLoad(5);
    }
 */





}
