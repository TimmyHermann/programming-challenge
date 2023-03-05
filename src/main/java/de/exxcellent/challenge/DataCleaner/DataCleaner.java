package de.exxcellent.challenge.DataCleaner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataCleaner {

    /**
     * Gets a file and a number of columns to keep and copies every row and the selected columns to a new array list.
     * This needs to be done, to clean the data.
     * @param data: the list with the data to process
     * @param columnsToCopy: how many columns to keep in the cleaned list, starting at the column 0
     * @return cleanedData: holds the cleaned data
     */
    public List<String[]> cleanWeatherData(List<String[]> data, int columnsToCopy){

        List<String[]> cleanedData = new ArrayList<>();

        for (String[] row : data) {
            String[] newRow = Arrays.copyOf(row, columnsToCopy); // copy the first 3 columns
            cleanedData.add(newRow);
        }
        return cleanedData;
    }
}
