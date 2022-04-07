package com.trycloud.pages;

import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.ConfigurationReader;
import com.trycloud.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FilesPage {
    public FilesPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy (xpath = "//a[@data-action='menu']")
    public List<WebElement> iconMore;

    @FindBy (xpath = "//span[.='Remove from favorites']")
    public WebElement removeFavorites;

    @FindBy (xpath = "//span[@class='icon icon-add']")
    public WebElement addIcon;

    @FindBy (xpath = "//input[@id='file_upload_start']")
    public WebElement uploadFile;

    @FindBy (xpath = "//span[@class='innernametext']")
    public List<WebElement> filesNames;

    @FindBy(xpath = "//a[@data-action='Favorite']//span[1]")
    public WebElement starFavoriteIcon;


    public void clickSubModule(String module){

        WebElement element = Driver.getDriver().findElement(By.xpath("//div[@id='app-navigation']//*[normalize-space(.)='"+module+"']"));
        BrowserUtils.highlight(element);
        element.click();
        BrowserUtils.waitForPageToLoad(5);
    }
}
