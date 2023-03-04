package de.exxcellent.challenge;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class DataReader {

    /**
     * Reads a file and puts its content into a list.
     * @param {string} pathToFile Path to the file that needs to be read
     */
    public List<String[]> readData(String pathToFile) {

        List<String[]> dataset = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(pathToFile));
            String line;
            while ((line = reader.readLine()) != null) {
               dataset.add(line.split(","));
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Something went wrong while reading the file");
        }

        return dataset;
    }
}