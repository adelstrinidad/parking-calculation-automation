package com.dataprovider;

import com.csv.CSVDataProvider;

import org.testng.annotations.DataProvider;

public class DataProviderClass {
    @DataProvider(name="getDataFromCSV")
    public static Object[][] getDataFromCSV() {
        return CSVDataProvider.getCSVData("data.csv");
    }

}
