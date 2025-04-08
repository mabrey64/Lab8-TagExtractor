import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileSaver
{
    private File saveFile;

    public FileSaver(File saveFile)
    {
        this.saveFile = saveFile;
    }

    public void saveTags(String tags)
    {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(saveFile)))
        {
            writer.write(tags);
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

}
