package de.exxcellent.challenge.Spread;

import de.exxcellent.challenge.DataCleaner.DataCleaner;
import de.exxcellent.challenge.Reader.DataReader;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SpreadCalculatorTest {

    @Test
    public void calculatedMinimalSpreadForWeatherData(){

        String dayWithMinSpread="14";

        DataReader reader = new DataReader();
        List<String[]> weatherData = reader.readData("src/main/resources/de/exxcellent/challenge/weather.csv");

        DataCleaner cleaner = new DataCleaner();
        List<String[]> cleanedWeatherData = cleaner.dataCleaner(weatherData, 0,1,2);

        SpreadCalculator calculateSpread = new SpreadCalculator();
        assertEquals(dayWithMinSpread,calculateSpread.calculateMinimalSpread(cleanedWeatherData));
    }

    @Test
    public void calculatedMinimalSpreadForFootballData(){
        String teamWithMinSpread="Aston_Villa";

        DataReader reader = new DataReader();
        List<String[]> footballData = reader.readData("src/main/resources/de/exxcellent/challenge/football.csv");

        DataCleaner cleaner = new DataCleaner();
        List<String[]> cleanedFootballData = cleaner.dataCleaner(footballData, 0,5,6);

        SpreadCalculator calculateSpread = new SpreadCalculator();
        assertEquals(teamWithMinSpread,calculateSpread.calculateMinimalSpread(cleanedFootballData));


    }

}