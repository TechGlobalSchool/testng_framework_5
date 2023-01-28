package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TechGlobalFileDownloadPage extends TechGlobalBasePage {

    public TechGlobalFileDownloadPage(){
        super();
    }

    @FindBy(id = "file_download")
    public WebElement fileDownloadLink;
}
