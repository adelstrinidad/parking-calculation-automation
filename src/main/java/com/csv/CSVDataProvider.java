package com.csv;

import com.csvreader.CsvReader;



public class CSVDataProvider {

    private static CsvReader reader = null;
    private static Object[][] data = null;
    private static final String PATH = "C:\\Adels\\projects\\parkingcalculatortest\\src\\main\\resources\\data.csv";



    private static void getData(String fileName) {
        int i = 0;
        try {
            data = new Object[6][9];
            reader = new CsvReader(PATH);
            reader.setUseComments(true);
            reader.setSkipEmptyRecords(true);
            while (reader.readRecord()) {
               data[i][0] = reader.get(0);
               data[i][1] = reader.get(1);
               data[i][2] = reader.get(2);
               data[i][3] = reader.get(3);
               data[i][4] = reader.get(4);
               data[i][5] = reader.get(5);
               data[i][6] = reader.get(6);
               data[i][7] = reader.get(7);
               data[i][8] = reader.get(8);
               i++;
            }
        }catch (Exception e) {
            System.out.println(e);

        }
    }

    public  static Object[][] getCSVData(String fileName) {
        getData(fileName);
        return data;
    }


}
