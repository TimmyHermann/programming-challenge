package de.exxcellent.challenge;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DataReaderTest {

    @Test
    void DataReaderShouldReadFile(){
        DataReader reader = new DataReader();
        assertNotNull(reader.readData("src/main/resources/de/exxcellent/challenge/weather.csv"));
    }

    @Test
    void DataReaderShouldNotReturnEmptyList(){
        DataReader reader = new DataReader();
        assertFalse(reader.readData("src/main/resources/de/exxcellent/challenge/weather.csv").isEmpty());
    }
}