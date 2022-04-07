package com.trycloud.step_definitions;


import com.trycloud.pages.DashboardPage;
import com.trycloud.pages.FilesPage;
import com.trycloud.pages.LoginPage;
import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.ConfigurationReader;
import com.trycloud.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.Assert;
import org.openqa.selenium.WebElement;


import java.util.ArrayList;
import java.util.List;

public class TryCloudStep_Definitions {
    LoginPage loginPage=new LoginPage();
    DashboardPage dashboardPage=new DashboardPage();
    FilesPage filesPage=new FilesPage();

   int i = 0;
    String filenameWithStar;

    @Given("user enters {string} and {string} in the log in page")
    public void user_enters_and_in_he_log_in_page(String username, String password) {
        Driver.getDriver().get(ConfigurationReader.getProperty("tryCloudURL"));
        loginPage.login(username, password);
        BrowserUtils.waitForPageToLoad(5);
    }
    @When("the user clicks the {string} module")
    public void the_user_clicks_the_module(String tab) {
      dashboardPage.navigateToTab(tab);

    }
    @When("the user clicks the add icon on the top")
    public void the_user_clicks_the_add_icon_on_the_top() {
      filesPage.addIcon.click();
        BrowserUtils.sleep(3);
    }



    @And("users uploads {string} with the upload file option")
    public void usersUploadsWithTheUploadFileOption(String file) {
       String pathOfProject= System.getProperty("user.dir");

       // System.out.println(pathOfProject);

        String pathOfFile="/src/test/resources/files/"+file;

       // System.out.println(pathOfFile);

        String path=pathOfProject+pathOfFile;

      //  System.out.println(path);

        filesPage.uploadFile.sendKeys(path);

        BrowserUtils.sleep(5);
    }

    @Then("verify the {string} is displayed on the page")
    public void verify_the_file_is_displayed_on_the_page(String fileNames) {
       List<String> actualFilesNames= new ArrayList<>();
       filesPage.filesNames.forEach(p-> actualFilesNames.add(p.getText()));
        System.out.println(actualFilesNames);
        System.out.println("Recent file name uploaded to Files: " + fileNames);
        Assert.assertTrue(actualFilesNames.contains(fileNames));
    }


    @When("the users click action-icon from any file on the page to remove")
    public void theUsersClickActionIconFromAnyFileOnThePageToRemove() {
        for (WebElement each : filesPage.iconMore) {
            each.click();
            if(filesPage.starFavoriteIcon.getAttribute("class").endsWith("dark"))
                break;
            i++;

            }
        filenameWithStar= filesPage.filesNames.get(i).getText();
        }



    @And("user choose the Remove from favorites option")
    public void userChooseTheRemoveFromFavoritesOption() {
        filesPage.removeFavorites.click();

    }

    @And("user click the {string} sub-module on the left side")
    public void userClickTheFavoritesSubModuleOnTheLeftSide(String module) {
        filesPage.clickSubModule(module);
    }

    @Then("Verify that the file is removed from the Favorites sub-module’s table")
    public void verifyThatTheFileIsRemovedFromTheFavoritesSubModuleSTable() {
        List<String> actualFavoriteFileNames = new ArrayList<>();
       filesPage.filesNames.forEach(p -> actualFavoriteFileNames.add(p.getText()));
        System.out.println("Recent file name deleted from Favorite: " + filenameWithStar);
        Assert.assertFalse(actualFavoriteFileNames.contains(filenameWithStar));

    }
}
