package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TechGlobalFileUploadPage extends TechGlobalBasePage{

    public TechGlobalFileUploadPage(){
        super();
    }

    @FindBy(id = "file_upload")
    public WebElement fileUploadInput;

    @FindBy(id = "file_submit")
    public WebElement uploadButton;

    @FindBy(id = "result")
    public WebElement resultText;
}
