package main;

/**
 * A demonstration class for the {@link FileOperations} utility class.
 * This class showcases how to use the file operations: writing to a file,
 * reading from a file, and counting lines in a file.
 */
public class Main {

    /**
     * The entry point of the application.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        String filePath = "example.txt";

        // Writing to a file
        System.out.println("Testing writeToFile...");
        FileOperations.writeToFile(filePath, "Hello, world!\nThis is a test.\nJava is fun!");

        // Reading from a file
        System.out.println("\nTesting readFromFile...");
        try {
            String content = FileOperations.readFromFile(filePath);
            System.out.println("File content:\n" + content);
        } catch (Exception e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        // Counting lines in a file
        System.out.println("\nTesting countLines...");
        try {
            int lines = FileOperations.countLines(filePath);
            System.out.println("Number of lines: " + lines);
        } catch (Exception e) {
            System.err.println("Error counting lines: " + e.getMessage());
        }
    }
}
