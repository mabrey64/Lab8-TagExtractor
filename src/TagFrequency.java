import java.io.File;
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
    }


}
