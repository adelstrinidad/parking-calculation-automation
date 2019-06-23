package com.dataprovider;

import com.csv.CSVDataProvider;

import org.testng.annotations.DataProvider;

/**
 *
 * @author Adelquis Trinidad
 */
public class DataProviderClass {

    /**
     *
     * @return Returns the data to fill the data provider that calls this method
     */
    @DataProvider(name="getDataFromCSV")
    public static Object[][] getDataFromCSV() {
        return CSVDataProvider.getCSVData("dataTest.csv");
    }

}

