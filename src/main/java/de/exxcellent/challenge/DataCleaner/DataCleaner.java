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

        List<String[]> cleanedWeatherData = new ArrayList<>();

        for (String[] row : data) {
            String[] newRow = Arrays.copyOf(row, columnsToCopy); // copy the first 3 columns
            cleanedWeatherData.add(newRow);
        }
        return cleanedWeatherData;
    }

    /**
     *
     * @param data: the list with the data to process
     * @param rowIndexName: position of the name column e.g. football data: name column = 0
     * @param rowIndexGoals position of the goals column
     * @param rowIndexGoalsAllowed position of the goals allowed column
     * @return cleanedData: holds the cleaned data
     */
    public List<String[]> cleanFootballData(List<String[]> data, int rowIndexName, int rowIndexGoals, int rowIndexGoalsAllowed){

        List<String[]> cleanedFootballData = new ArrayList<>(data.size());
        int[] columnsToSelect = {rowIndexName,rowIndexGoals,rowIndexGoalsAllowed};

        for (String[] row : data) {
            String[] newRow = new String[columnsToSelect.length];
            for (int i = 0; i < columnsToSelect.length; i++) {
                int col = columnsToSelect[i];
                newRow[i] = row[col];
            }
            cleanedFootballData.add(newRow);
        }

        return cleanedFootballData;
    }
}
