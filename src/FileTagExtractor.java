import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.util.Map;

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
                String selectedFilePath = Paths[0].toString().replace("Selected file: ", "").trim();
                String filterFilePath = Paths[1].toString().replace("Selected trap word file: ", "").trim();

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

