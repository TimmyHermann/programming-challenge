package de.exxcellent.challenge;
import de.exxcellent.challenge.DataCleaner.DataCleaner;
import de.exxcellent.challenge.Reader.DataReader;
import de.exxcellent.challenge.Spread.SpreadCalculator;

import java.util.List;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public final class App {

    /**
     * This is the main entry method of your program.
     * @param args The CLI arguments passed
     */
    public static void main(String... args) {

        // read the data
        DataReader reader = new DataReader();
        List<String[]> weatherData = reader.readData("src/main/resources/de/exxcellent/challenge/weather.csv");
        List<String[]> footballData = reader.readData("src/main/resources/de/exxcellent/challenge/football.csv");

        // clean the data
        DataCleaner cleaner = new DataCleaner();
        List<String[]> cleanedWeatherData = cleaner.dataCleaner(weatherData, 0,1,2);
        List<String[]> cleanedFootballData = cleaner.dataCleaner(footballData, 0,5,6);

        // calculate spread
        SpreadCalculator calculateSpread = new SpreadCalculator();
        String dayWithMinimalSpread = calculateSpread.calculateMinimalSpread(cleanedWeatherData);
        String teamWithMinimalSpread = calculateSpread.calculateMinimalSpread(cleanedFootballData);

        // output
        String dayWithSmallestTempSpread = dayWithMinimalSpread;     // Your day analysis function call …
        System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);

        String teamWithSmallestGoalSpread = teamWithMinimalSpread; // Your goal analysis function call …
        System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallestGoalSpread);
    }
}
