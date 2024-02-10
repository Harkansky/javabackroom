package com.fges.todoapp;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class StorageController {
    public static String readFileContent(String fileName) throws IOException {
        Path filePath = Paths.get(fileName);
        return Files.exists(filePath) ? Files.readString(filePath) : "";
    }

    public static void writeToFile(String fileName, String content) throws IOException {
        Files.writeString(Paths.get(fileName), content);
    }

    public static void appendToFile(String fileName, String content) throws IOException {
        Files.writeString(Paths.get(fileName), content, java.nio.file.StandardOpenOption.APPEND);
    }

    public static void createFile(String fileName) throws IOException {
        Path filePath = Paths.get(fileName);
        if (!Files.exists(filePath)) {
            Files.createFile(filePath);
        }
    }
}