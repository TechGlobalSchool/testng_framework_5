package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TechGlobalDropdownsPage extends TechGlobalBasePage {

    public TechGlobalDropdownsPage(){
        super();
    }

    @FindBy()
    public WebElement productDropdownLabel;

    @FindBy()
    public WebElement productDropdown;

    @FindBy()
    public WebElement colorDropdownLabel;

    @FindBy()
    public WebElement colorDropdown;

    @FindBy(xpath = "//div[@id='shipment_dropdown']/../p")
    public WebElement deliveryDropdownLabel;

    @FindBy(id = "shipment_dropdown")
    public WebElement deliveryDropdown;

    @FindBy(css = "#shipment_dropdown span")
    public List<WebElement> deliveryDropdownOptions;

    @FindBy()
    public WebElement submitButton;

    @FindBy()
    public WebElement resultTag;

    @FindBy()
    public WebElement resultMessage;
}
