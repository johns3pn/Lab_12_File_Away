import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DataSaver {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        ArrayList<String> records = new ArrayList<>();

        boolean done = false;

        while (!done) {

            String firstName = SafeInput.getNonZeroLenString(in, "Enter first name");
            String lastName = SafeInput.getNonZeroLenString(in, "Enter last name");
            String idNumber = SafeInput.getRegExString(in, "Enter 6-digit ID Number", "\\d{6}");
            String email = SafeInput.getNonZeroLenString(in, "Enter email");
            int birthYear = SafeInput.getRangedInt(in, "Enter year of birth", 1000, 9999);

            String record = firstName + "," +
                    lastName + "," +
                    idNumber + "," +
                    email + "," +
                    birthYear;

            records.add(record);

            done = !SafeInput.getYNConfirm(in, "Would you like to enter another record?");
        }

        String fileName = SafeInput.getNonZeroLenString(in, "Enter the output file name");

        if (!fileName.endsWith(".csv")) {
            fileName += ".csv";
        }

        File outputFile = new File(System.getProperty("user.dir") + "/src/" + fileName);

        try {
            FileWriter writer = new FileWriter(outputFile);

            for (String record : records) {
                writer.write(record + System.lineSeparator());
            }

            writer.close();

            System.out.println("\nCSV file saved successfully!");
            System.out.println("Location: " + outputFile.getAbsolutePath());

        } catch (IOException e) {
            System.out.println("Error writing file.");
            e.printStackTrace();

        }

        in.close();
    }
}


