package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.Waiter;

import java.util.List;

public class TechGlobalCalendarPage extends TechGlobalBasePage{
    public TechGlobalCalendarPage(){
        super();
    }

    @FindBy(css = "button[class*='_cal']")
    public WebElement calendarButton;

    @FindBy(css = "button[class*='_next2']")
    public WebElement nextYearButton;

    @FindBy(css = "button[class*='_next-']")
    public WebElement nextMonthButton;

    @FindBy(css = "span[class*='label']")
    public WebElement yearText;

    @FindBy(css = "button[class*='__day']")
    public List<WebElement> dates;

    @FindBy(id = "result")
    public WebElement result;

    public void clickOnDate(int dateNumber){
        for (WebElement date : dates) {
            if(Integer.parseInt(date.getText()) == dateNumber){
                date.click();
                break;
            }
        }
    }

    public void navigateToYearAndMonth(int year, String month){
        while (!yearText.getText().contains(Integer.toString(year))){
            Waiter.pause(1);
            nextYearButton.click();
        }

        while(!yearText.getText().contains(month)){
            Waiter.pause(1);
            nextMonthButton.click();
        }

    }
}
