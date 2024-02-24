package com.fges.todoapp;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.ParseException;

import java.io.IOException;
import java.util.List;

public class App {

    /**
     * Do not change this method
     */
    public static void main(String[] args) throws Exception {
        System.exit(exec(args));
    }

    public static int exec(String[] args) throws IOException, ParseException {
        CommandLine cmd = CommandParser.parseArguments(args);
        String fileName = cmd.getOptionValue("s");

        List<String> positionalArgs = cmd.getArgList();
        if (positionalArgs.isEmpty()) {
            System.err.println("Missing Command");
            return 1;
        }

        String command = positionalArgs.get(0);

        TodoController todoController;

        if (command.equals("insert")) {
            boolean isDone = cmd.hasOption("done");
            String description = String.join(" ", positionalArgs.subList(1, positionalArgs.size()));
            TodoItem todo = new TodoItem(description, isDone);

            if (fileName.endsWith(".json")) {
                todoController = new JsonTodoController();
            } else if (fileName.endsWith(".csv")) {
                todoController = new CsvTodoController();
            } else {
                System.err.println("Unsupported file format");
                return 1;
            }

            todoController.insertTodo(fileName, todo);
        }

        if (command.equals("list")) {
            if (fileName.endsWith(".json")) {
                todoController = new JsonTodoController();
            } else if (fileName.endsWith(".csv")) {
                todoController = new CsvTodoController();
            } else {
                System.err.println("Unsupported file format");
                return 1;
            }

            boolean showDone = cmd.hasOption("done");
            todoController.listTodos(fileName, showDone);

        }

        if (command.equals("migrate")) {
            if (fileName.endsWith(".csv")) {
                todoController = new CsvTodoController();
            } else if (fileName.endsWith(".json")) {
                todoController = new JsonTodoController();
            } else {
                System.err.println("Unsupported file format");
                return 1;
            }

            String newFileName = cmd.getOptionValue("o");
            todoController.migrate(fileName, newFileName);
        }

        // System.err.println("Done.");
        return 0;
    }

}