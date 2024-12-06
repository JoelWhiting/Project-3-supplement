package test;

import main.FileOperations;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FileOperationsTest {

    private final String testFilePath = "test.txt";

    @AfterEach
    void cleanUp() {
        File file = new File(testFilePath);
        if (file.exists()) {
            file.delete();
        }
    }

    @Test
    void testWriteToFile() {
        FileOperations.writeToFile(testFilePath, "Hello, world!");
        File file = new File(testFilePath);
        assertTrue(file.exists());
    }

    @Test
    void testReadFromFile() throws IOException {
        FileOperations.writeToFile(testFilePath, "Hello, world!");
        String content = FileOperations.readFromFile(testFilePath);
        assertEquals("Hello, world!", content);
    }

    @Test
    void testCountLines() throws IOException {
        FileOperations.writeToFile(testFilePath, "Line 1\nLine 2\nLine 3");
        int lines = FileOperations.countLines(testFilePath);
        assertEquals(3, lines);
    }
}
