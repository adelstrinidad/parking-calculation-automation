package com.parkingcalculatortest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.Calendar;

import static com.parkingcalculatortest.DriverFactory.getChromeDriver;

public class CalendarPage {
    WebDriver driver = getChromeDriver();

    @FindBy(name = "MonthSelector")
    WebElement monthSelector;

    @FindBy(css = "td[align=\"right\"] > font")
    WebElement yearSelector;

    @FindBy(css = "td[align=\"right\"] > font + a")
    WebElement nextYearSelector;

    @FindBy(css = "td[align=\"right\"] > a")
    WebElement beforeYearSelector;

    /**
     *
     */
    public  CalendarPage(){
        PageFactory.initElements(driver,this);
    }

    /**
     *
     * @param date date in format mm/dd/yyyy
     */
    public void setDate(String date){
        String[] partDate = date.split("/");
        selectMonth(partDate[0]);
        selectYear(partDate[2]);
        selectDay(partDate[1]);
        selectWindow();

    }

    /**
     *
     * @param day day value
     */
    private void selectDay(String day) {
        //TODO create my own finder so I can do it dynamically
        driver.findElement(By.linkText(removeZeroInDay(day))).click();
    }

    /**
     *
     * @param day day value
     * @return day without zero in first place
     */
    private String removeZeroInDay(String day) {
        return day.replaceFirst("^0", "");
    }

    /**
     *
     * @param year year value
     */
    private void selectYear(String year) {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int yearParser = Integer.parseInt(year);
        int difference = currentYear - yearParser;
        if(difference >0){
            for(int i=0; i < difference; i++) {
                beforeYearSelector.click();
            }
            }else{
                for(int i=0; difference < i; difference++) {
                nextYearSelector.click();
            }

            }

        }

    /**
     *
     * @param month month value
     */
    private void selectMonth(String month) {
        selectWindow();

        Select selectByValue = new Select(monthSelector);
        String monthName = theMonth(month);

        selectByValue.selectByVisibleText(monthName);

    }

    /**
     *
     */
    private void selectWindow() {
        //TODO move this method to a Util class
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
    }

    /**
     *
     * @param month month value index
     * @return the name of the month
     */
    private String theMonth(String month){
        int monthIndex = Integer.parseInt(month);
        String[] monthNames = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        return monthNames[monthIndex- 1];

    }
}
