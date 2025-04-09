import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * TagFrequency is a class that calculates the frequency of tags in a given file.
 * It reads the file, processes the content, and counts the occurrences of each tag.
 * The class also handles stop words to exclude them from the frequency count.
 * The main method demonstrates how to use this class to calculate tag frequencies.
 */

public class TagFrequency
{
    Map<String, Integer> tagFrequencyMap;
    File selectedFile;
    File filterFile;
    Set<String> stopWords;

    // Constructor to initialize the TagFrequency object with the selected file and filter file
    public TagFrequency(String selectedFilePath, String filterFilePath)
    {
        this.selectedFile = new File(selectedFilePath);
        this.filterFile = new File(filterFilePath);
        System.out.println("Looking for stop words file at: " + this.filterFile.getAbsolutePath());
        this.tagFrequencyMap = new TreeMap<>();
        this.stopWords = new HashSet<>();
        loadStopWords();
    }

    // Method to load stop words from the specified filter file
    // It reads the file line by line and adds each stop word to a set for quick lookup
    // The method also handles exceptions and ensures that the file is closed properly
    private void loadStopWords() {
        System.out.println("Loading stop words from: " + this.filterFile.getAbsolutePath());
        if (!this.filterFile.exists()) {
            throw new RuntimeException("Stop words file not found: " + this.filterFile.getAbsolutePath());
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(this.filterFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                stopWords.add(line.trim().toLowerCase()); // Normalize stop words
            }
        } catch (IOException e) {
            throw new RuntimeException("Error loading stop words: " + e.getMessage());
        }
    }

    // Method to calculate the frequency of tags in the selected file
    // It reads the file line by line, processes each word, and updates the frequency map
    // The method also handles exceptions and ensures that the file is closed properly
    public Map<String, Integer> calculateTagFrequency() {
        try (BufferedReader reader = new BufferedReader(new FileReader(this.selectedFile))) {
            String record;
            // Implement the logic to read the selected file and calculate tag frequency
            // Store the results in the tagFrequencyMap
            while ((record = reader.readLine()) != null) {
                for (String word : record.toLowerCase().replaceAll("[^a-zA-Z\\s]", " ").split("\\s+")) {
                    if  (word.isEmpty() || stopWords.contains(word)) {
                        continue; // Skip empty words and stop words
                    }
                    tagFrequencyMap.put(word, tagFrequencyMap.getOrDefault(word, 0) + 1);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Reached end of calculateTagFrequency method");
        return tagFrequencyMap;
    }
}
