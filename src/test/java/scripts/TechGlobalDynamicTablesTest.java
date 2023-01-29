package scripts;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TechGlobalAlertsPage;
import pages.TechGlobalDynamicTablesPage;
import pages.TechGlobalFrontendTestingHomePage;
import utilities.TableData;
import utilities.Waiter;

import java.util.stream.IntStream;

public class TechGlobalDynamicTablesTest extends TechGlobalBase{

    @BeforeMethod
    public void setPage(){
        techGlobalFrontendTestingHomePage = new TechGlobalFrontendTestingHomePage();
        techGlobalDynamicTablesPage = new TechGlobalDynamicTablesPage();
        techGlobalFrontendTestingHomePage.getFrontendTestingPage();
        techGlobalFrontendTestingHomePage.clickOnCard("Dynamic Tables");
    }

    /**
     * REGULAR MODAL AUTOMATION (this is not a JS alert)
     * Go to https://techglobal-training.netlify.app/
     * Click on "Practices" dropdown in the header
     * Select the "Frontend Testing" option
     * Click on the "Dynamic Tables" card
     * Click on the "ADD PRODUCT" button
     * Validate the modal title equals "Add New Product"
     */
    @Test(priority = 1, description = "pop up validation")
    public void popupValidation(){
        techGlobalDynamicTablesPage.addProductButton.click();
        Assert.assertEquals(techGlobalDynamicTablesPage.modalCardTitle.getText(), "Add New Product");
        Waiter.pause(3);
    }

    /**
     * Go to https://techglobal-training.netlify.app/
     * Click on “Practices” dropdown in the header
     * Select the “Frontend Testing” option
     * Click on the “Dynamic Tables” card
     * Click the “Add Product” button
     * Enter “2” in the Quantity field
     * Enter “Apple Watch” in the Product field
     * Enter “500” in the Price $ field
     * Click the “Submit” button
     * Verify that a new row has been added to the table with the values “2”, “Apple Watch, “500” and the calculated Total $ value is “1,000"
     * Verify that the Total $ value at the bottom of the table has been updated to reflect the total cost of all the products in the table, including the newly added one.
     */

    @Test(priority = 2, description = "Validate dynamic table")
    public void validateDynamicTable(){
        techGlobalDynamicTablesPage.addProductButton.click();

        int initialTotal = Integer.parseInt(techGlobalDynamicTablesPage.totalAmount.getText().replaceAll("[^0-9]", ""));

        Assert.assertEquals(techGlobalDynamicTablesPage.modalCardTitle.getText(), "Add New Product");

        String[] products = {"2", "Apple Watch", "500"};

        int tableRowSize = techGlobalDynamicTablesPage.tableRow.size();

        Assert.assertEquals(techGlobalDynamicTablesPage.tableRow.size(), 3);

        int myProductTotal = Integer.parseInt(products[0]) * Integer.parseInt(products[2]);

        IntStream.range(0, products.length).forEach(i -> techGlobalDynamicTablesPage.productDetails.get(i).sendKeys(products[i]));

        techGlobalDynamicTablesPage.submitButton.click();

        Assert.assertEquals(techGlobalDynamicTablesPage.tableRow.size(), tableRowSize + 1);

        int productTotal = Integer.parseInt(TableData.getTableRow(driver, 4).get(3).getText().replaceAll("[^0-9]", ""));


    }
}
