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
        List<String[]> cleanedWeatherData = cleaner.cleanWeatherData(weatherData, 3);
        SpreadCalculator calculateSpread = new SpreadCalculator();
        assertEquals(dayWithMinSpread,calculateSpread.calculateMinimalSpread(cleanedWeatherData));
    }

}