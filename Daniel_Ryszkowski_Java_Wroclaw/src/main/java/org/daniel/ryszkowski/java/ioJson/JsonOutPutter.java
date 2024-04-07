package org.daniel.ryszkowski.java.ioJson;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * This class is responsible for writing Java objects into JSON files.
 */
public class JsonOutPutter {

    /**
     * Writes a Map<String, List<String>> into a JSON file.
     * @param filePath The path to the JSON file.
     * @param data The data to be written to the file.
     */
    public void writeJsonFile(String filePath, Map<String, List<String>> data) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            objectMapper.writeValue(new File(filePath), data);
        } catch (IOException e) {
            System.out.println("Error while writing to file: " + e.getMessage());
        }
    }

}