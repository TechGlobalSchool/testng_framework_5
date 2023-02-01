package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TechGlobalActionsPage extends TechGlobalBasePage {
    public TechGlobalActionsPage(){
        super();
    }

    @FindBy(id = "click")
    public WebElement clickBox;

    @FindBy(id = "click_result")
    public WebElement clickResult;

    @FindBy(id = "right-click")
    public WebElement rightClickBox;

    @FindBy(id = "right_click_result")
    public WebElement rightClickResult;

    @FindBy(id = "double-click")
    public WebElement doubleClickBox;

    @FindBy(id = "double_click_result")
    public WebElement doubleClickResult;

    @FindBy(id = "drag_element")
    public WebElement dragMeBox;

    @FindBy(id = "drop_element")
    public WebElement dropHereBox;

    @FindBy(id = "drag_and_drop_result")
    public WebElement dragAndDropResult;


    @FindBy(id = "input_box")
    public WebElement inputBox;


}
