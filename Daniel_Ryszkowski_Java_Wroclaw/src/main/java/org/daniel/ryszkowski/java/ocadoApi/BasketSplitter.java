package org.daniel.ryszkowski.java.ocadoApi;

import org.daniel.ryszkowski.java.ioJson.JsonInPutter;
import java.util.*;

/**
 * This class is responsible for splitting a basket of items into groups based on their delivery methods.
 * The delivery methods for each item are read from a JSON configuration file.
 */
public class BasketSplitter {


    // Object for reading JSON files
    private final JsonInPutter jsonInPutter = new JsonInPutter();

    // Configuration map read from the JSON file
    private final Map<String, List<String>> config;

    /**
     * Constructor that initializes the configuration map.
     * @param absolutePathToConfigFile The absolute path to the JSON configuration file.
     */
    public BasketSplitter(String absolutePathToConfigFile) {
        this.config = jsonInPutter.readJsonConfigFile(absolutePathToConfigFile);
    }

    /**
     * Splits the given list of items into groups based on their delivery methods.
     * @param items The list of items to be split.
     * @return A map where the keys are delivery methods and the values are lists of items for each delivery method.
     * @throws IllegalArgumentException if the items or config is null.
     */
    public Map<String, List<String>> split(List<String> items) {

        if(items == null || config == null) throw new IllegalArgumentException("Items or config is null");

        // Initialize the map to store the grouped products
        Map<String, List<String>> groupedProducts = new HashMap<>();

        // Iterate over each item
        items.forEach(item -> {
            // Get the most common delivery method for the current item
            if(!config.containsKey(item)){
                System.out.println("Item: " + item + " is not in the configuration file.");
                return;
            }
           String mostCommonDelivery = getMostCommonDelivery(config.get(item));

            // Add the current item to the list of items for the most common delivery method
            groupedProducts.computeIfAbsent(mostCommonDelivery, k -> new ArrayList<>()).add(item);
            //System.out.println("Item: " + item + " Delivery method: " + config.get(item));
        });

        // Return the map of grouped products
        return groupedProducts;
    }

    /**
     * Finds the most common delivery method in the given list.
     * @param deliveryMethods The list of delivery methods.
     * @return The most common delivery method.
     */
    private String getMostCommonDelivery(List<String> deliveryMethods) {
        // Initialize the map to count the occurrences of each delivery method
        Map<String, Integer> countMap = new HashMap<>();

        // Count the occurrences of each delivery method
        deliveryMethods.forEach(deliveryMethod -> countMap.merge(deliveryMethod, 1, Integer::sum));

        // Return the most common delivery method
        return Collections.max(countMap.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    /**
     * Getter for the JsonInPutter object.
     * @return The JsonInPutter object used to read the JSON configuration file.
     */
    public JsonInPutter getJsonInPutter() {
        return jsonInPutter;
    }

}