package com.fges.todoapp;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class JsonDataStorage implements DataStorage {

    private static final String FILE_PATH = "todos.json";

    @Override
    public void saveTodos(List<TodoItem> todos) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        String todosJson = mapper.writeValueAsString(todos);
        Files.writeString(Paths.get(FILE_PATH), todosJson);
    }

    @Override
    public List<TodoItem> loadTodos() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        if (!Files.exists(Paths.get(FILE_PATH))) {
            return new ArrayList<>();
        }
        String todosJson = Files.readString(Paths.get(FILE_PATH));
        return mapper.readValue(todosJson, new TypeReference<List<TodoItem>>() {});
    }
}

