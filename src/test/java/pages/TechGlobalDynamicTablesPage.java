package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TechGlobalDynamicTablesPage extends TechGlobalBasePage{
    public TechGlobalDynamicTablesPage(){
        super();
    }

    @FindBy(id = "add_product_btn")
    public WebElement addProductButton;

    @FindBy(id = "modal_title")
    public WebElement modalCardTitle;
}
