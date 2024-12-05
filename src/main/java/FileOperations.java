package main;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileOperations {

    public static void writeToFile(String filePath, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content);
        } catch (IOException e) {
            throw new RuntimeException("Error writing to file: " + filePath, e);
        }
    }

    public static String readFromFile(String filePath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }

    public static int countLines(String filePath) throws IOException {
        return (int) Files.lines(Paths.get(filePath)).count();
    }
}
