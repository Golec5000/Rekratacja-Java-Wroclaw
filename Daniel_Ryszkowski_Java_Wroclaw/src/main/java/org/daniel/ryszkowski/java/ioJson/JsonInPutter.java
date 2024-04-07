package org.daniel.ryszkowski.java.ioJson;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * This class is responsible for reading JSON files and converting them into Java objects.
 */
public class JsonInPutter {

    /**
     * Reads a JSON configuration file and converts it into a Map<String, List<String>>.
     * @param filePath The path to the JSON file.
     * @return A Map<String, List<String>> representing the JSON file content, or null if an error occurred.
     */
    public Map<String, List<String>> readJsonConfigFile(String filePath) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            return objectMapper.readValue(new File(filePath), new TypeReference<>() {});
        } catch (IOException | NullPointerException e) {
            System.out.println("Error while reading JSON file: " + e.getMessage());
            return null;
        }
    }

    /**
     * Reads a JSON basket file and converts it into a List<String>.
     * @param filePath The path to the JSON file.
     * @return A List<String> representing the JSON file content, or null if an error occurred.
     */
    public List<String> readJsonBasketFile(String filePath) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            return objectMapper.readValue(new File(filePath), new TypeReference<>() {});
        } catch (IOException | NullPointerException e) {
            System.out.println("Error while reading JSON file: " + e.getMessage());
            return null;
        }
    }
}