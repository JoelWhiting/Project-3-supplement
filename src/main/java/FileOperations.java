package main;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * A utility class for performing basic file operations such as writing content to a file,
 * reading content from a file, and counting the number of lines in a file.
 */
public final class FileOperations {

    /**
     * Private constructor to prevent instantiation of this utility class.
     */
    private FileOperations() {
        // Prevent instantiation
    }

    /**
     * Writes the specified content to a file at the given file path.
     *
     * @param filePath the path to the file where the content should be written
     * @param content  the content to write into the file
     * @throws RuntimeException if an I/O error occurs during the write operation
     */
    public static void writeToFile(String filePath, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content);
        } catch (IOException e) {
            throw new RuntimeException("Error writing to file: " + filePath, e);
        }
    }

    /**
     * Reads the content of a file from the specified file path.
     *
     * @param filePath the path to the file to read
     * @return a string containing the content of the file
     * @throws IOException if an I/O error occurs while reading the file
     */
    public static String readFromFile(String filePath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }

    /**
     * Counts the number of lines in a file at the specified file path.
     *
     * @param filePath the path to the file whose lines should be counted
     * @return the number of lines in the file
     * @throws IOException if an I/O error occurs while reading the file
     */
    public static int countLines(String filePath) throws IOException {
        return (int) Files.lines(Paths.get(filePath)).count();
    }
}
