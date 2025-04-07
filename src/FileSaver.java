import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileSaver
{
    private File selectedFile;
    private String filePath;

    public FileSaver(File selectedFile)
    {
        this.selectedFile = selectedFile;
        this.filePath = selectedFile.getAbsolutePath();
    }

    public void saveTags(String tags)
    {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath)))
        {
            writer.write(tags);
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

}
