package de.exxcellent.challenge.Spread;

import java.util.List;

public class SpreadCalculator {
    /**
     * Calculates the minimal spread for a day (Column 0) from max. (Column 1) and min. (Column 2) value
     * @param cleanedWeatherData: the data taht needs to be read
     * @return the day with the minimal temperature spread
     */
    public String calculateMinimalSpread(List<String[]> cleanedWeatherData){
        float minSpread=0;
        String dayOfMinSpread="";
        boolean skippedFirstIteration = false;

        for (String[] rows: cleanedWeatherData) {

            // need to skip first iteration because in the first row are the column names
            if (!skippedFirstIteration) {
                skippedFirstIteration = true;
                continue;
            }

            String day = rows[0];
            float max = Float.parseFloat(rows[1]);
            float min = Float.parseFloat(rows[2]);
            float spread = max-min;
            // It is necessary to get the amount, because with football data negative values are possible
            spread = Math.abs(spread);

            // set the first day and spread as a baseline
            if(dayOfMinSpread == "" && minSpread==0){
                dayOfMinSpread=day;
                minSpread=max-min;
            }

            if(spread < minSpread){
               dayOfMinSpread=day;
               minSpread=spread;
            }

        }
        return dayOfMinSpread;
    }
}
