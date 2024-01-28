package com.fges.todoapp;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.MissingNode;
import org.apache.commons.cli.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Hello world!
 */
public class App {

    /**
     * Do not change this method
     */
    public static void main(String[] args) throws Exception {
        System.exit(exec(args));
    }

    public static int exec(String[] args) {
        CommandLineParser parser = new DefaultParser();
        Options cliOptions = new Options();
        cliOptions.addRequiredOption("s", "source", true, "File containing the todos");
        CommandLine cmd;

        try {
            cmd = parser.parse(cliOptions, args);
        } catch (ParseException ex) {
            System.err.println("Failed to parse arguments: " + ex.getMessage());
            return 1;
        }

        String fileName = cmd.getOptionValue("s");
        DataStorage dataStorage = getDataStorage(fileName);

        if (dataStorage == null) {
            System.err.println("Unsupported file type for: " + fileName);
            return 1;
        }

        TodoController todoController = new TodoController(dataStorage);
        CommandParser commandParser = new CommandParser(args);

        try {
            String command = commandParser.getCommand();
            List<String> arguments = commandParser.getPositionalArgs();

            return switch (command.toLowerCase()) {
                case "insert" -> todoController.insertTodo(arguments.get(1));
                case "list" -> todoController.listTodos();
                default -> {
                    System.err.println("Unknown command: " + command);
                    yield 1;
                }
            };
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
            return 1;
        }
    }

    private static DataStorage getDataStorage(String fileName) {
        if (fileName.endsWith(".json")) {
            return new JsonDataStorage();
        } else if (fileName.endsWith(".csv")) {
            return new CsvDataStorage();
        } else {
            return null;
        }
    }
}
