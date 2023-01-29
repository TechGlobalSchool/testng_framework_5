package scripts;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TechGlobalAlertsPage;
import pages.TechGlobalDynamicTablesPage;
import pages.TechGlobalFrontendTestingHomePage;
import utilities.TableData;
import utilities.TextHandler;
import utilities.Waiter;

import java.util.List;
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

        // storing initial table row size and validate it is 3
        int tableRowSize = techGlobalDynamicTablesPage.tableRow.size();
        Assert.assertEquals(techGlobalDynamicTablesPage.tableRow.size(), 3);

        // store the current total amount before adding a new product and parse it to an int
        int initialTotal = TextHandler.getInt(techGlobalDynamicTablesPage.totalAmount.getText());
        techGlobalDynamicTablesPage.addProductButton.click();


        // validate that the modal card is displayed by its title
        Assert.assertEquals(techGlobalDynamicTablesPage.modalCardTitle.getText(), "Add New Product");

        // storing all the products in an array so we can add it
        String[] products = {"2", "Apple Watch", "2,000"};

        // calculate the total amount of the new product by multiplying quantity with price
        int myProductTotal = TextHandler.getInt(products[0]) * TextHandler.getInt(products[2]) ;

        // enter the values from the products array into the corresponding input fields
        IntStream.range(0, products.length).forEach(i -> techGlobalDynamicTablesPage.productDetails.get(i).sendKeys(products[i]));

        // submit the form to add the new product to our table
        techGlobalDynamicTablesPage.submitButton.click();

        // then validate that there are now 4 rows in the table.
        Assert.assertEquals(techGlobalDynamicTablesPage.tableRow.size(), tableRowSize + 1);

        // get the total amount of the newly added product from the table
        int productTotalAmount = TextHandler.getInt(TableData.getTableRow(driver, 4).get(3).getText());

        // get the row of the table that we need to check
        List<WebElement> tableRow = TableData.getTableRow(driver, 4);

        // validate that the values in the table match the values from product array
        IntStream.range(0, tableRow.size()-1).forEach(i -> Assert.assertEquals(tableRow.get(i).getText(), products[i]));

        // Also, validate that the total amount of the newly added product matches the calculated value
        Assert.assertEquals(productTotalAmount, myProductTotal);

        // get the final total amount from the table.
        int newTotal = TextHandler.getInt(techGlobalDynamicTablesPage.totalAmount.getText());

        // calculate the expected total amount by adding the total of the newly added product to the initial total
        int expectedTotal = initialTotal + myProductTotal;

        // validate that the current total matches the expected total
        Assert.assertEquals(newTotal, expectedTotal);
    }
}
