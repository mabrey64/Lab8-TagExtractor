import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.util.Map;

/**
 * FileTagExtractor is the main class that serves as the entry point for the program.
 * It initializes the GUI and handles user interactions.
 * The program allows users to select a file and a trap word file,
 * and then calculates and displays the frequency of tags in the selected file.
 */

public class FileTagExtractor
{
    public static void main(String[] args)
    {
        TagDisplayFrame tagDisplayFrame = new TagDisplayFrame();
        String filePath = tagDisplayFrame.returnFileName();
        if (filePath == null || filePath.isEmpty() || filePath.contains("None")) {
            System.out.println("No file selected.");
            return;
        }    else {
                String[] Paths = filePath.split(";");
                String selectedFilePath = Paths[0].trim();
                String filterFilePath = Paths[1].trim();

            if (selectedFilePath.isEmpty() || filterFilePath.isEmpty()) {
                System.out.println("Invalid file paths.");
                return;
            }

                TagFrequency tagFrequency = new TagFrequency(selectedFilePath, filterFilePath);
                Map<String, Integer> tagFrequencyMap = tagFrequency.calculateTagFrequency();

                tagFrequencyMap.forEach((tag, frequency) -> {
                    System.out.println(tag + ": " + frequency);
                });
            }
        }
}

