import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * FileSaver is a utility class that provides functionality to save
 * tag frequencies to a specified file.
 * It handles the file writing process and ensures that
 * the data is saved correctly.
 * In this class, we use a BufferedWriter to write the tag frequencies
 * to the file and save it in a user-friendly format.
 * Multiple copies of the tags were saved while editing the code and then testing things out
 */

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
