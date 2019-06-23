package com.csv;

import com.csvreader.CsvReader;

import java.io.File;

public class CSVDataProvider {

    private static CsvReader reader = null;
    private static Object[][] data = null;
    private static final String TARGET_PATH = "src/main/resources/";

    /**
     *
     * @param fileName the name of the csv file
     */
    private static void getData(String fileName) {
        String path = getFilePath(fileName);

        int i = 0;
        try {
            int rows = calculateRowsInCsvFile(path);
            int columns = calculateColumnsInCsvFile(path);
            data = new Object[rows][columns];
            reader = new CsvReader(path);
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

    /**
     *
     * @param fileName the name of the csv file
     * @return the absolute path of the csv file
     */
    private static String getFilePath(String fileName) {
        File file = new File(TARGET_PATH);
        String absolutePath = file.getAbsolutePath();

        return absolutePath + "\\" +fileName;
    }

    /**
     *
     * @param path absolute path for the csv file
     * @return the number of row that the csv file contains
     */
    private static int calculateRowsInCsvFile(String path) {
        int i = 0;
        try {
            reader = new CsvReader(path);
            reader.setSkipEmptyRecords(false);
            while (reader.readRecord()) {
                i++;
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return  i;
    }

    /**
     *
     * @param path absolute path for the csv file
     * @return the number of columns that the csv file contains
     */
    private static int calculateColumnsInCsvFile(String path) {
        int numberColumns = 0;
        try {
            reader = new CsvReader(path);
            reader.setSkipEmptyRecords(false);
            reader.readRecord();
            numberColumns = reader.getColumnCount();

        }catch (Exception e){
            System.out.println(e);
        }
        return numberColumns;
    }

    /**
     *
     * @param fileName the csv file name
     * @return An object with the data gotten from the csv file
     */
    public  static Object[][] getCSVData(String fileName) {
        getData(fileName);
        return data;
    }


}
