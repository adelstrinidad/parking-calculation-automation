package com.parkingcalculatortest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ParkingCalculatorPage {
    WebDriver driver = DriverFactory.getChromeDriver();
    WebDriverWait wait = DriverFactory.getWebDriverWait();

    public void chooseLot(String lot) {
        driver.findElement(By.cssSelector("option[value="+ lot + "]")).click();
    }

    public void chooseDateTime(String dateFieldSelector, String time){
        WebElement entryDateTimeField = driver.findElement(By.id(dateFieldSelector));
        entryDateTimeField.clear();
        entryDateTimeField.sendKeys(time);
    }

    public void choosePeriodTimeRB(String time, String periodOfTime) {
        driver.findElement(By.cssSelector("#"+ time + " ~ input[value="+ periodOfTime + "]")).click();
    }

    public void submit() {
        driver.findElement(By.name("Submit")).click();
    }

    public String calculateCost() {
        return driver.findElement(By.cssSelector(".SubHead > font > b")).getText();
    }

    public void setDate(String entryDate, String date) {
        WebElement entryDateTimeField = driver.findElement(By.name(entryDate));
        entryDateTimeField.clear();
        entryDateTimeField.sendKeys(date);
    }

    public String obtainTimeConsumed() {
        String[] output = driver.findElement(By.cssSelector(".BodyCopy > font > b")).getText().split("(?=\\()");
        return output[1];
    }
}
