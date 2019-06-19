package com.parkingcalculatortest.tests;

import com.dataprovider.DataProviderClass;
import com.parkingcalculatortest.BaseTestClass;
import com.parkingcalculatortest.ParkingCalculatorPage;

import org.testng.annotations.Test;

import static com.parkingcalculatortest.ParkingCalculatorPage.getParkingCalculationPage;
import static org.assertj.core.api.Assertions.assertThat;

public class ParkingCalculatorPageTest extends BaseTestClass {
    private static final String ENTRY_TIME = "EntryTime";
    private static final String EXIT_TIME = "ExitTime";
    private static final String ENTRY_DATE = "EntryDate";
    private static final String EXIT_DATE = "ExitDate";


    ParkingCalculatorPage parkingCalculator = getParkingCalculationPage();

    @Test(dataProvider = "getDataFromCSV", dataProviderClass = DataProviderClass.class)
    public void calculateParkingTestCSV(String lot, String startTime, String periodOfTimeEntry, String startDate, String endTime, String periodOfTimeExit,String endDate,  String cost, String timeSpent ) throws InterruptedException {

        parkingCalculator.chooseLot(lot)
                .chooseDateTime(ENTRY_TIME, startTime)
                .choosePeriodTimeRB(ENTRY_TIME, periodOfTimeEntry)
                .setDate(ENTRY_DATE,startDate)
                .chooseDateTime(EXIT_TIME, endTime)
                .choosePeriodTimeRB(EXIT_TIME, periodOfTimeExit)
                .setDate(EXIT_DATE,endDate)
                .submit();


        assertThat(cost).isEqualTo(parkingCalculator.calculateCost());
        if(!cost.contains("ERROR")){
            assertThat(timeSpent).isEqualTo(parkingCalculator.obtainTimeConsumed());
        }
    }

}
