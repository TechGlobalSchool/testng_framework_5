package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TechGlobalDropdownsPage extends TechGlobalBasePage {

    public TechGlobalDropdownsPage(){
        super();
    }

    @FindBy(xpath = "//select[@id='product_dropdown']/../p")
    public WebElement productDropdownLabel;

    @FindBy(id = "product_dropdown")
    public WebElement productDropdown;

    @FindBy(xpath = "//select[@id='color_dropdown']/../p")
    public WebElement colorDropdownLabel;

    @FindBy(id = "color_dropdown")
    public WebElement colorDropdown;

    @FindBy(xpath = "//div[@id='shipment_dropdown']/../p")
    public WebElement deliveryDropdownLabel;

    @FindBy(id = "shipment_dropdown")
    public WebElement deliveryDropdown;

    @FindBy(css = "#shipment_dropdown span")
    public List<WebElement> deliveryDropdownOptions;

    @FindBy(id = "submit")
    public WebElement submitButton;

    @FindBy(css = ".title")
    public WebElement resultTag;

    @FindBy(id = "result")
    public WebElement resultMessage;
}
