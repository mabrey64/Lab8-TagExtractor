import javax.swing.*;
import java.io.File;
import java.awt.*;
import java.nio.file.Path;

public class TagDisplayFrame extends JFrame
{
    JPanel mainTagPanel; // Main panel for the overall layout
    JPanel tagPanel; // Panel for choosing (or typing in) the tag
    JPanel tagDisplayPanel; // Panel for displaying the tags & its frequencies
    JPanel buttonPanel; // Panel for the buttons

    JLabel selectedFileLabel; // Label to display the selected file
    JLabel selectedTrapFileLabel; // Label to display the selected trap word file

    JFileChooser fileChooser; // File chooser for selecting files
    File selectedFile; // The file selected by the user

    JButton chooseFileButton; // Button to choose a file
    JButton chooseStopFileButton; // Button to choose a stop file
    JButton tagExtractButton; // Button to display the tag frequencies
    JButton saveButton; // Button to save the tag frequencies to a file
    JButton exitButton; // Button to exit the program

    JTextArea tagDisplayArea; // Text area for displaying the tag frequencies

    public TagDisplayFrame()
    {
        // Set the title and default close operation
        setTitle("Tags & Frequency Display");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initialize the main panel and set its layout
        mainTagPanel = new JPanel();
        mainTagPanel.setLayout(new BoxLayout(mainTagPanel, BoxLayout.Y_AXIS));

        // Initialize the file chooser and set its properties
        fileChooser = new JFileChooser(new File(System.getProperty("user.dir")));
        File selectedFile = null;

        // Initialize the tag panel and add components to it
        tagPanel = new JPanel();
        selectedFileLabel = new JLabel("Currently selected file: None");
        selectedTrapFileLabel = new JLabel("Currently selected trap word file: None");
        tagPanel.add(selectedFileLabel);
        tagPanel.add(selectedTrapFileLabel);

        buttonPanel();

        // Initialize the tag display panel and add components to it
        tagDisplayPanel = new JPanel();
        tagDisplayArea = new JTextArea(20, 50);
        tagDisplayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(tagDisplayArea);
        tagDisplayPanel.add(scrollPane);

        // Add panels to the main panel
        mainTagPanel.add(tagPanel);
        mainTagPanel.add(tagDisplayPanel);

        // Add the main panel to the frame
        add(mainTagPanel);

        // Pack and set the frame to be visible
        pack();
        setVisible(true);
    }

    public void buttonPanel() {
        // Create a new JPanel for the button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        chooseFileButton = new JButton("Choose File");
        chooseStopFileButton = new JButton("Choose Stop File");
        tagExtractButton = new JButton("Extract Tags");
        saveButton = new JButton("Save Tags");
        exitButton = new JButton("Exit");

        // Add buttons to the button panel
        buttonPanel.add(chooseFileButton);
        buttonPanel.add(chooseStopFileButton);
        buttonPanel.add(tagExtractButton);
        buttonPanel.add(saveButton);
        buttonPanel.add(exitButton);

        // Add action listeners to the buttons
        chooseFileButton.addActionListener(e -> {
            choosefileAction();
        });
        chooseStopFileButton.addActionListener(e -> {
            choosefileAction();
        });

        exitButton.addActionListener(e -> {
            int response = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?", "Exit", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });


        mainTagPanel.add(buttonPanel);
    }

    private void choosefileAction()
    {
        int returnValue = fileChooser.showOpenDialog(this);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            selectedFile = fileChooser.getSelectedFile();
            selectedFileLabel.setText("Selected file: " + selectedFile.getName());
            tagDisplayArea.setText("File successfully loaded.");
        } else {
            tagDisplayArea.setText("File selection failed.");
        }
    }
}
