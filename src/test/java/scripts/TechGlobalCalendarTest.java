package scripts;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TechGlobalCalendarPage;
import pages.TechGlobalFrontendTestingHomePage;
import utilities.Waiter;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class TechGlobalCalendarTest extends TechGlobalBase{

    @BeforeMethod
    public void setPage(){
        techGlobalFrontendTestingHomePage = new TechGlobalFrontendTestingHomePage();
        techGlobalCalendarPage = new TechGlobalCalendarPage();
        techGlobalFrontendTestingHomePage.getFrontendTestingPage();
        techGlobalFrontendTestingHomePage.clickOnCard("Calendar");
    }

    /**
     * Go to https://techglobal-training.netlify.app/
     * Click on "Practices" dropdown in the header
     * Select the "Frontend Testing" option
     * Click on the "Calendar" card
     * Click on the calendar input field to open the date picker
     * Click the next button until the year 2024 is displayed
     * Click on the month button until May
     * Click on a specific date, for example the 16th
     * Validate that the text displayed on the result is "You have selected Thu May 16 2024."
     */

    @Test(priority = 1, description = "Validate date picker")
    public void ValidateDatePicker(){

        techGlobalCalendarPage.calendarButton.click();

        int year = 2024, month = 5, day = 16;

        String monthSting = Month.of(month).toString().charAt(0) + Month.of(month).toString().substring(1).toLowerCase();


        techGlobalCalendarPage.navigateToYearAndMonth(year, monthSting);

        techGlobalCalendarPage.clickOnDate(day);

        LocalDate selectedDate = LocalDate.of(year, month, day);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE MMM dd yyyy");
        String expectedDate = selectedDate.format(formatter);

        Assert.assertEquals(techGlobalCalendarPage.result.getText(), "You have selected " + expectedDate + ".");
    }
}
