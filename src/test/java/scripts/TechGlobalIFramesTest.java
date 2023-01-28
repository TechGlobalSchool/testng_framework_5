package scripts;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TechGlobalFrontendTestingHomePage;
import pages.TechGlobalIFramesPage;
import utilities.Waiter;

public class TechGlobalIFramesTest extends TechGlobalBase {

    /**
     * Go to https://techglobal-training.netlify.app/
     * Click on “Practices” dropdown in the header
     * Select the “Frontend Testing” option
     * Click on the “IFrames” card
     * Validate the “Please fill out your information below” text
     */

    @BeforeMethod
    public void setPage(){
        techGlobalFrontendTestingHomePage = new TechGlobalFrontendTestingHomePage();
        techGlobalIFramesPage = new TechGlobalIFramesPage();
        techGlobalFrontendTestingHomePage.getFrontendTestingPage();
        techGlobalFrontendTestingHomePage.clickOnCard("IFrames");
    }

    @Test(priority = 1, description = "Validating input header text")
    public void validateInputText(){
        driver.switchTo().frame(techGlobalIFramesPage.iFrameId);
        Assert.assertTrue(techGlobalIFramesPage.inputHeader.isDisplayed());
        Assert.assertEquals(techGlobalIFramesPage.inputHeader.getText(), "Please fill out your information below");
        Waiter.pause(3);
    }
}
