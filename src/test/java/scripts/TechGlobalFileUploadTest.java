package scripts;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TechGlobalFileUploadPage;
import pages.TechGlobalFrontendTestingHomePage;
import utilities.Waiter;

public class TechGlobalFileUploadTest extends TechGlobalBase{

    @BeforeMethod
    public void setPage(){
        techGlobalFrontendTestingHomePage = new TechGlobalFrontendTestingHomePage();
        techGlobalFileUploadPage = new TechGlobalFileUploadPage();
        techGlobalFrontendTestingHomePage.getFrontendTestingPage();
        techGlobalFrontendTestingHomePage.clickOnCard("File Upload");
    }

    /**
     * Go to https://techglobal-training.netlify.app/
     * Click on "Practices" dropdown in the header
     * Select the "Frontend Testing" option
     * Click on the "File Upload" card
     * Send path of the file as keys to "Choose File" input box
     * Click on "UPLOAD" button
     * Validate the result message equals "You Uploaded 'hello.txt'"
     */

    @Test(priority = 1, description = "Validate file upload")
    public void validateFileUpload(){

        String filePath = "/Users/techglobal/IdeaProjects/testng_framework_5/hello.txt";
        techGlobalFileUploadPage.fileUploadInput.sendKeys(filePath);
        techGlobalFileUploadPage.uploadButton.click();

        Assert.assertEquals(techGlobalFileUploadPage.resultText.getText(), "You Uploaded '" + filePath.substring(filePath.lastIndexOf('/')+1) +"'");

        Waiter.pause(3);
    }
}
