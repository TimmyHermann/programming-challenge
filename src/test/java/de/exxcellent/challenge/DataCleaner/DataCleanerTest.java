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
        List<String[]> cleanWeatherData = cleaner.dataCleaner(weatherData,0,1,2);

        for (String[] row : cleanWeatherData) {
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
        List<String[]> cleanWeatherData = cleaner.dataCleaner(weatherData,0,1,2);

        for (String[] col : cleanWeatherData) {
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

    @Test
    public void footballDataCleanerShouldReturnListWithJustThreeSpecificColumns(){
        String firstCol="";
        String secondCol="";
        String thirdCol="";

        DataCleaner cleaner = new DataCleaner();
        DataReader reader = new DataReader();
        List<String[]> footballData = reader.readData("src/main/resources/de/exxcellent/challenge/football.csv");
        List<String[]> cleanFootballData = cleaner.dataCleaner(footballData, 0, 5,6);

        for (String[] col : cleanFootballData) {
            firstCol= col[0];
            secondCol= col[1];
            thirdCol= col[2];
            // This break is necessary, because only one iteration is needed
            break;
        }
        assertEquals("Team",firstCol);
        assertEquals("Goals",secondCol);
        assertEquals("Goals Allowed",thirdCol);

    }
}