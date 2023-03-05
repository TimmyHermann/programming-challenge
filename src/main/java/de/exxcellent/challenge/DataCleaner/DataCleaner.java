package de.exxcellent.challenge.DataCleaner;

import java.util.ArrayList;
import java.util.List;

public class DataCleaner {

    /**
     *
     * @param data: the list with the data to process
     * @param rowIndexName: position of the name column e.g. football data: name column = 0
     * @param rowIndexGoals position of the goals column
     * @param rowIndexGoalsAllowed position of the goals allowed column
     * @return cleanedData: holds the cleaned data
     */
    public List<String[]> dataCleaner(List<String[]> data, int rowIndexName, int rowIndexGoals, int rowIndexGoalsAllowed){

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
