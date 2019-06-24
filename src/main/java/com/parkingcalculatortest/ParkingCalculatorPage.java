package com.parkingcalculatortest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import static com.parkingcalculatortest.DriverFactory.getChromeDriver;

/**
 *
 * @author Adelquis Trinidad
 */
public class ParkingCalculatorPage {
    WebDriver driver = getChromeDriver();

    @FindBy(name="Lot")
    WebElement lotDpd;

    @FindBy(id="EntryTime")
    WebElement entryTimeField;

    @FindBy(id="ExitTime")
    WebElement exitTimeField;

    @FindBy(id="EntryDate")
    WebElement entryDateField;

    @FindBy(id="ExitDate")
    WebElement exitDateField;

    @FindBy(css="#EntryTime ~ input[value=AM]")
    WebElement entryTimeAM;

    @FindBy(css="#EntryTime ~ input[value=PM]")
    WebElement entryTimePM;

    @FindBy(css="#ExitTime ~ input[value=AM]")
    WebElement exitTimeAM;

    @FindBy(css="#ExitTime ~ input[value=PM]")
    WebElement exitTimePM;

    @FindBy(name="Submit")
    WebElement submitButton;

    @FindBy(css=".SubHead > font > b")
    WebElement costLabel;

    @FindBy(css=".BodyCopy > font > b")
    WebElement timeConsumedLabel;

    @FindBy(css="#EntryDate + a")
    WebElement entryDateCalendar;

    @FindBy(css="#ExitDate + a")
    WebElement exitDateCalendar;

    /**
     *
     */
    public  ParkingCalculatorPage(){
        PageFactory.initElements(driver,this);
    }


    /**
     *
     * @param lot lot abbreviation
     * @return ParkingCalculatorPage
     */
    public ParkingCalculatorPage chooseLot(String lot) {
        Select selectByValue = new Select(lotDpd);
        selectByValue.selectByValue(lot);
        return  this;
    }

    /**
     * @param timeSelector specify if is the entry time or exit time
     * @param time the hour specified as mm:ss
     * @return ParkingCalculatorPage
     */
    public ParkingCalculatorPage chooseDateTime(String timeSelector, String time){
        if(timeSelector.equals("EntryTime")){
            entryTimeField.clear();
            entryTimeField.sendKeys(time);
        }else{
            exitTimeField.clear();
            exitTimeField.sendKeys(time);
        }

        return this;
    }

    /**
     *
     * @param timeSelector specify if is the entry time or exit time
     * @param periodOfTime period of time AM or PM
     * @return ParkingCalculatorPage
     */
    public ParkingCalculatorPage choosePeriodTimeRB(String timeSelector, String periodOfTime) {
        if(timeSelector.equals("EntryTime")){
            if(periodOfTime.equals("AM")) {
                entryTimeAM.click();
            }else{
                entryTimePM.click();
            }
        }else{
            if(periodOfTime.equals("AM")){
                exitTimeAM.click();
            }else {
                exitTimePM.click();
            }

        }
        return this;
    }

    /**
     *
     */
    public void submit() {
        submitButton.click();

    }

    /**
     *
     * @return Cost of parking
     */
    public String calculateCost() {
        return costLabel.getText();
    }

    /**
     *
     * @param date date of entry
     * @return ParkingCalculatorPage
     */
    public ParkingCalculatorPage setEntryDate(String date) {
        entryDateField.clear();
        entryDateField.sendKeys(date);
        return this;
    }

    /**
     *
     * @param entryDate entry date value
     * @return ParkingCalculatorPage
     */
    public ParkingCalculatorPage setEntryDateCalendar(String entryDate) {
        CalendarPage calendarPage = new CalendarPage();
        entryDateCalendar.click();

        calendarPage.setDate(entryDate);

        return this;
    }

    /**
     *
     * @param exitDate exit date value
     * @return ParkingCalculatorPage
     */
    public ParkingCalculatorPage setExitDateCalendar(String exitDate) {
        CalendarPage calendarPage = new CalendarPage();
        exitDateCalendar.click();

        calendarPage.setDate(exitDate);

        return this;
    }

    /**
     *
     * @param date date of exit
     * @return ParkingCalculatorPage
     */
    public ParkingCalculatorPage setExitDate(String date) {
        exitDateField.clear();
        exitDateField.sendKeys(date);
        return this;
    }

    /**
     *
     * @return time consumed
     */
    public String obtainTimeConsumed() {
        String[] output = timeConsumedLabel.getText().split("(?=\\()");
        return output[1];
    }
}
