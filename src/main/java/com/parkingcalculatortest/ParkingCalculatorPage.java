package com.parkingcalculatortest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author Adelquis Trinidad
 */
public class ParkingCalculatorPage {
    WebDriver driver = DriverFactory.getChromeDriver();
    WebDriverWait wait = DriverFactory.getWebDriverWait();

    /**
     *
     * @param lot lot abbreviation
     * @return ParkingCalculatorPage
     */
    public ParkingCalculatorPage chooseLot(String lot) {
        driver.findElement(By.cssSelector("option[value="+ lot + "]")).click();
        return  this;
    }

    /**
     * @param timeFieldSelector specify if is the entry time or exit time
     * @param time the hour specified as mm:ss
     * @return ParkingCalculatorPage
     */
    public ParkingCalculatorPage chooseDateTime(String timeFieldSelector, String time){
        WebElement entryDateTimeField = driver.findElement(By.id(timeFieldSelector));
        entryDateTimeField.clear();
        entryDateTimeField.sendKeys(time);
        return this;
    }

    /**
     *
     * @param timeFieldSelector specify if is the entry time or exit time
     * @param periodOfTime period of time AM or PM
     * @return ParkingCalculatorPage
     */
    public ParkingCalculatorPage choosePeriodTimeRB(String timeFieldSelector, String periodOfTime) {
        driver.findElement(By.cssSelector("#"+ timeFieldSelector + " ~ input[value="+ periodOfTime + "]")).click();
        return this;
    }

    /**
     *
     */
    public void submit() {
        driver.findElement(By.name("Submit")).click();
    }

    /**
     *
     * @return Cost of parking
     */
    public String calculateCost() {
        return driver.findElement(By.cssSelector(".SubHead > font > b")).getText();
    }

    /**
     *
     * @param entryOrExitTime the type of time, entry or exit
     * @param date date of entry or exit
     * @return ParkingCalculatorPage
     */
    public ParkingCalculatorPage setDate(String entryOrExitTime, String date) {
        WebElement entryDateTimeField = driver.findElement(By.name(entryOrExitTime));
        entryDateTimeField.clear();
        entryDateTimeField.sendKeys(date);
        return this;
    }

    /**
     *
     * @return time consumed
     */
    public String obtainTimeConsumed() {
        String[] output = driver.findElement(By.cssSelector(".BodyCopy > font > b")).getText().split("(?=\\()");
        return output[1];
    }
}
