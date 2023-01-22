package scripts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TechGlobalDropdownsPage;
import pages.TechGlobalFrontendTestingHomePage;
import utilities.DropdownHandler;
import utilities.Waiter;

public class TechGlobalDropdownsTest extends TechGlobalBase{

    @BeforeMethod
    public void setPage(){
        techGlobalFrontendTestingHomePage = new TechGlobalFrontendTestingHomePage();
        techGlobalDropdownsPage = new TechGlobalDropdownsPage();
    }

    @Test(priority = 1, description = "Select Delivery option")
    public void selectDeliveryOption(){
        techGlobalFrontendTestingHomePage.getFrontendTestingPage();
        techGlobalFrontendTestingHomePage.clickOnCard("Dropdowns");

        DropdownHandler.clickOnDropdownOption(techGlobalDropdownsPage.deliveryDropdown,
                                                techGlobalDropdownsPage.deliveryDropdownOptions,
                                                "Delivery");

        Waiter.pause(5);
    }
}
