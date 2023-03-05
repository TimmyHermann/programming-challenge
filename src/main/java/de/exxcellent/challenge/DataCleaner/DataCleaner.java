package de.exxcellent.challenge.DataCleaner;

import java.util.ArrayList;
import java.util.List;

public class DataCleaner {

    /**
     *
     * @param data: the list with the data to process
     * @param rowIndexName: position of the name column e.g. football data: name column = 0
     * @param rowIndexMax position of the max column
     * @param rowIndexMin position of the min column
     * @return cleanedData: returns the cleaned dataset with only 3 columns
     */
    public List<String[]> dataCleaner(List<String[]> data, int rowIndexName, int rowIndexMax, int rowIndexMin){

        List<String[]> cleanedFootballData = new ArrayList<>(data.size());
        int[] columnsToSelect = {rowIndexName,rowIndexMax,rowIndexMin};

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
