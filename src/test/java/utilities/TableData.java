package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TableData {


    public static List<WebElement> getTableRow(WebDriver driver, int rowNumber){
        return driver.findElements((By.cssSelector("tbody tr:nth-child(" + rowNumber + ") td")));
    }

    public static List<WebElement> getTableColumn(WebDriver driver, int columnNumber){
        return driver.findElements((By.cssSelector("tbody td:nth-child(" + columnNumber + ")")));
    }
}
