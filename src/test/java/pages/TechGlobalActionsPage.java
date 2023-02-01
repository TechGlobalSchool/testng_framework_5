package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TechGlobalActionsPage extends TechGlobalBasePage {
    public TechGlobalActionsPage(){
        super();
    }

    @FindBy(id = "")
    public WebElement clickBox;

    @FindBy(id = "")
    public WebElement clickResult;

    @FindBy(id = "")
    public WebElement rightClickBox;

    @FindBy(id = "")
    public WebElement rightClickResult;

    @FindBy(id = "")
    public WebElement doubleClickBox;

    @FindBy(id = "")
    public WebElement doubleClickResult;

    @FindBy(id = "")
    public WebElement dragMeBox;

    @FindBy(id = "")
    public WebElement dropHereBox;

    @FindBy(id = "")
    public WebElement inputBox;
}
