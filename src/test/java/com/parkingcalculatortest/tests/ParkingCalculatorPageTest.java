package com.parkingcalculatortest.tests;

import com.dataprovider.DataProviderClass;
import com.parkingcalculatortest.BaseTestClass;
import com.parkingcalculatortest.ParkingCalculatorPage;

import org.testng.annotations.Test;


import static org.assertj.core.api.Assertions.assertThat;

public class ParkingCalculatorPageTest extends BaseTestClass {
    private static final String ENTRY_TIME = "EntryTime";
    private static final String EXIT_TIME = "ExitTime";


    ParkingCalculatorPage parkingCalculator;

    @Test(dataProvider = "getDataFromCSV", dataProviderClass = DataProviderClass.class)
    public void calculateParkingTestCSV(String lot, String startTime, String periodOfTimeEntry, String startDate, String endTime, String periodOfTimeExit,String endDate,  String cost, String timeSpent ) throws InterruptedException {
        parkingCalculator = new ParkingCalculatorPage();

        parkingCalculator.chooseLot(lot)
                .chooseDateTime(ENTRY_TIME, startTime)
                .choosePeriodTimeRB(ENTRY_TIME, periodOfTimeEntry)
                .setEntryDate(startDate)
                .chooseDateTime(EXIT_TIME, endTime)
                .choosePeriodTimeRB(EXIT_TIME, periodOfTimeExit)
                .setExitDate(endDate)
                .submit();


        assertThat(cost).isEqualTo(parkingCalculator.calculateCost());
        assertThat(timeSpent).isEqualTo(parkingCalculator.obtainTimeConsumed());
    }

}
