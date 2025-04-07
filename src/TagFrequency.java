import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TagFrequency
{
    Map<String, Integer> tagFrequencyMap;
    File selectedFile;
    File filterFile;

    public TagFrequency(String selectedFilePath, String filterFilePath)
    {
        this.selectedFile = new File(selectedFilePath);
        this.filterFile = new File(filterFilePath);
        this.tagFrequencyMap = new HashMap<>();
    }

    public Map<String, Integer> calculateTagFrequency() {
        try (BufferedReader reader = new BufferedReader(new FileReader(this.selectedFile))) {
            String record;
            // Implement the logic to read the selected file and calculate tag frequency
            // Store the results in the tagFrequencyMap
            while ((record = reader.readLine()) != null) {
                for (String word : record.split("\\s+")) {
                    // Check if the word is a tag and update the frequency in the map
                    if (tagFrequencyMap.containsKey(word)) {
                        tagFrequencyMap.put(word, tagFrequencyMap.get(word) + 1);
                    } else {
                        tagFrequencyMap.put(word, 1);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Reached end of calculateTagFrequency method");
        return tagFrequencyMap;
    }
}
