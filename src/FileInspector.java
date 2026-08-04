import javax.swing.JFileChooser;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class FileInspector {

    public static void main(String[] args) {

        JFileChooser chooser = new JFileChooser();

        // Open JFileChooser in the project's src directory
        File workingDirectory = new File(System.getProperty("user.dir") + "/src");
        chooser.setCurrentDirectory(workingDirectory);

        chooser.setDialogTitle("Choose a text file");

        int result = chooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {

            File selectedFile = chooser.getSelectedFile();
            Path filePath = selectedFile.toPath();

            int lineCount = 0;
            int wordCount = 0;
            int charCount = 0;

            System.out.println("=================================");
            System.out.println("Contents of File:");
            System.out.println("=================================");

            try {
                Scanner inputFile = new Scanner(filePath);

                while (inputFile.hasNextLine()) {

                    String line = inputFile.nextLine();

                    // Display the line
                    System.out.println(line);

                    // Count lines
                    lineCount++;

                    // Count words
                    if (!line.trim().isEmpty()) {
                        String[] words = line.trim().split("\\s+");
                        wordCount += words.length;
                    }

                    // Count characters (not including newline characters)
                    charCount += line.length();
                }

                inputFile.close();

                // Summary Report
                System.out.println();
                System.out.println("=================================");
                System.out.println("File Summary");
                System.out.println("=================================");
                System.out.println("File Name: " + selectedFile.getName());
                System.out.println("Number of Lines: " + lineCount);
                System.out.println("Number of Words: " + wordCount);
                System.out.println("Number of Characters: " + charCount);

            } catch (IOException e) {
                System.out.println("Error reading file.");
                e.printStackTrace();
            }

        } else {
            System.out.println("No file selected.");
        }
    }
}
