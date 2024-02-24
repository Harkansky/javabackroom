package com.fges.todoapp;

import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Stream;

public class CsvTodoController implements TodoController {
    @Override
    public void insertTodo(String fileName, TodoItem todo) throws IOException {
        StorageController.createFile(fileName);
        StorageController.appendToFile(fileName, todo.getName() + "`" + todo.isDone() + "\n");
    }

    @Override
    public void listTodos(String fileName, boolean showDone) throws IOException {
        String content = StorageController.readFileContent(fileName);
        Stream<String> lines = Arrays.stream(content.split("\n"));
        lines
            .map(line -> line.split("`"))
            //.filter(parts -> showDone || !Boolean.parseBoolean(parts[1]))
            .map(parts -> (parts[1].equals("true") ? "- Done: " : "- ") + parts[0])
            .forEach(System.out::print);
    }

    @Override
    public void migrate(String from, String to) throws IOException {
        String content = StorageController.readFileContent(from);
        StorageController.writeToFile(to, content);
    }
}