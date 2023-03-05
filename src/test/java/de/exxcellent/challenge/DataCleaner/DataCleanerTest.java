package de.exxcellent.challenge.DataCleaner;

import de.exxcellent.challenge.Reader.DataReader;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DataCleanerTest {

    @Test
    public void DataCleanerShouldReturnListWithJustThreeColumns(){
        DataCleaner cleaner = new DataCleaner();
        DataReader reader = new DataReader();
        List<String[]> weatherData = reader.readData("src/main/resources/de/exxcellent/challenge/weather.csv");
        List<String[]> cleanData = cleaner.cleanWeatherData(weatherData,3);
        for (String[] row : cleanData) {
            assertEquals(3, row.length);
        }
    }

    @Test
    public void weatherDataCleanerShouldReturnListWithJustThreeSpecificColumns(){

        String firstCol="";
        String secondCol="";
        String thirdCol="";

        DataCleaner cleaner = new DataCleaner();
        DataReader reader = new DataReader();
        List<String[]> weatherData = reader.readData("src/main/resources/de/exxcellent/challenge/weather.csv");
        List<String[]> cleanData = cleaner.cleanWeatherData(weatherData,3);
        for (String[] col : cleanData) {
            firstCol= col[0];
            secondCol= col[1];
            thirdCol= col[2];
            // This break is necessary, because only one iteration is needed
            break;
        }
        assertEquals("Day",firstCol);
        assertEquals("MxT",secondCol);
        assertEquals("MnT",thirdCol);
    }
}