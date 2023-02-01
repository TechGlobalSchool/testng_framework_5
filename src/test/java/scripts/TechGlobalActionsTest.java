package scripts;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TechGlobalActionsPage;
import pages.TechGlobalFrontendTestingHomePage;
import utilities.Waiter;

import java.time.Duration;

public class TechGlobalActionsTest extends TechGlobalBase{

    @BeforeMethod
    public void setPage(){
        techGlobalFrontendTestingHomePage = new TechGlobalFrontendTestingHomePage();
        techGlobalActionsPage = new TechGlobalActionsPage();
        techGlobalFrontendTestingHomePage.getFrontendTestingPage();
        techGlobalFrontendTestingHomePage.clickOnCard("Actions");
        actions = new Actions(driver);
    }

    /**
     * TEST1
     * Go to https://techglobal-training.netlify.app/
     * Click on the "Practices" dropdown in the header
     * Select the "Frontend Testing" option from the dropdown menu
     * Click on the "Actions" card
     * Verify that the user is redirected to the Actions page
     * Verify that the first three web elements are present and labeled as "Click on me", "Right-Click on me", and "Double-Click on me"
     * Perform a click action on the first web element labeled as "Click on me"
     * Verify that  message appears next of the element stating "You clicked on a button!"
     * Perform a right click action on the second web element labeled as "Right-Click on me""
     * Verify that  message appears next of the element stating "You right-clicked on a button!"
     * Perform a double click action on the third web element labeled as "Double-Click on me"
     * Verify that  message appears next of the element stating "You double-clicked on a button!"
     */

    @Test(priority = 1, description = "Click first 3 boxes and validate the results")
    public void clickActions(){
        actions.moveToElement(techGlobalActionsPage.clickBox).click().perform();
        Waiter.pause(2);
        Assert.assertEquals(techGlobalActionsPage.clickResult.getText(), "You clicked on a button!");

        actions.moveToElement(techGlobalActionsPage.rightClickBox).contextClick().perform();
        Waiter.pause(2);

        Assert.assertEquals(techGlobalActionsPage.rightClickResult.getText(), "You right-clicked on a button!");

        actions.moveToElement(techGlobalActionsPage.doubleClickBox).doubleClick().perform();
        Waiter.pause(2);

        Assert.assertEquals(techGlobalActionsPage.doubleClickResult.getText(), "You double-clicked on a button!");
    }

    /**
     * TEST2
     * Go to https://techglobal-training.netlify.app/
     * Click on the "Practices" dropdown in the header
     * Select the "Frontend Testing" option from the dropdown menu
     * Click on the "Actions" card
     * Verify that the last two web elements are present and labeled as "Drag Me", and "Drop Here",
     * Perform a Drag and Drop action on the "Drag Me" web element, and drop it to "Drop Here"
     * Verify that the first web element "Drag me" is successfully dropped into the second web element "Drop Here"
     * Verify that a message appears next to the  web element stating "An element dropped here!"
     */

    //Move to an element, click and hold the element, and move it to Drop Here, and release it there

    @Test(priority = 2, description = "Drag and Drop action")
    public void dragAndDropAction(){
//        actions.moveToElement(techGlobalActionsPage.dragMeBox).clickAndHold()
//                .moveToElement(techGlobalActionsPage.dropHereBox).release().perform();
//
        actions.dragAndDrop(techGlobalActionsPage.dragMeBox, techGlobalActionsPage.dropHereBox).perform();

        Waiter.waitForVisibilityOfElement(techGlobalActionsPage.dragAndDropResult, 10);
        Assert.assertEquals(techGlobalActionsPage.dragAndDropResult.getText(), "An element dropped here!");
    }

    /**
     * Go to https://techglobal-training.netlify.app/
     * Click on the "Practices" dropdown in the header
     * Select the "Frontend Testing" option from the dropdown menu
     * Click on the "Actions" card
     * Go to input box, and remove existing text inside
     * Enter “Hello” to search input box
     * Validate value attribute is “Hello”
     */

    @Test(priority = 3, description = "Keyboard actions")
    public void keyboardActions(){

        actions.keyDown(Keys.SHIFT)
                .sendKeys(techGlobalActionsPage.inputBox, "h")
                .keyUp(Keys.SHIFT)
                .pause(Duration.ofSeconds(2))
                .sendKeys("ello")
                .pause(Duration.ofSeconds(2))
                .perform();

        Assert.assertEquals(techGlobalActionsPage.inputBox.getAttribute("value"), "Hello");

    }

    /**
     * TEST4
     * Go to https://techglobal-training.netlify.app/
     * Click on the "Practices" dropdown in the header
     * Select the "Frontend Testing" option from the dropdown menu
     * Click on the "Actions" card
     * Go to input box, and remove existing text inside
     * Enter “techglobal” to input box with uppercases
     * Validate the value attribute for search input box is “TECHGLOBAL”
     * Then, copy the text and paste again
     * Validate the value attribute for search input box is “TECHGLOBALTECHGLOBAL”
     */

    @Test(priority = 4, description = "More keyboard actions")
    public void moreKeyboardActions(){

        actions.keyDown(Keys.SHIFT)
                .sendKeys(techGlobalActionsPage.inputBox, "techglobal")
                .keyUp(Keys.SHIFT)
                .pause(Duration.ofSeconds(2))
                .keyDown(Keys.COMMAND)
                .sendKeys("a")
                .pause(Duration.ofSeconds(2))
                .sendKeys("c")
                .keyUp(Keys.COMMAND)
                .sendKeys(Keys.ARROW_RIGHT)
                .keyDown(Keys.COMMAND)
                .sendKeys("v")
                .pause(Duration.ofSeconds(2))
                .perform();

        Assert.assertEquals(techGlobalActionsPage.inputBox.getAttribute("value"), "TECHGLOBALTECHGLOBAL");
    }
}
