import java.io.*;
import java.util.Scanner;

public class FileHandlerUtility {

    private static final String FILE_PATH = "sample.txt";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- FILE HANDLING UTILITY ---");
            System.out.println("1. Write to file");
            System.out.println("2. Read from file");
            System.out.println("3. Append to file");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();  // consume newline

            switch (choice) {
                case 1:
                    writeToFile(sc);
                    break;
                case 2:
                    readFromFile();
                    break;
                case 3:
                    appendToFile(sc);
                    break;
                case 4:
                    System.out.println("Exiting File Handler.");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 4);

        sc.close();
    }

    // Write new content to file (overwrite)
    private static void writeToFile(Scanner sc) {
        System.out.println("Enter text to write to file:");
        String text = sc.nextLine();

        try (FileWriter fw = new FileWriter(FILE_PATH)) {
            fw.write(text);
            System.out.println("File written successfully.");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    // Read and display file contents
    private static void readFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            System.out.println("\n--- File Contents ---");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println("----------------------");
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    // Append content to file
    private static void appendToFile(Scanner sc) {
        System.out.println("Enter text to append to file:");
        String text = sc.nextLine();

        try (FileWriter fw = new FileWriter(FILE_PATH, true)) {
            fw.write("\n" + text);
            System.out.println("Text appended successfully.");
        } catch (IOException e) {
            System.out.println("Error appending to file: " + e.getMessage());
        }
    }
}
