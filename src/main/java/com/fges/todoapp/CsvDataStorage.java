package com.fges.todoapp;

import java.io.IOException;
import java.util.List;

public class CsvDataStorage implements DataStorage{
    @Override
    public void saveTodos(List<TodoItem> todos) throws IOException {
        //saves todos in csv format

    }

    @Override
    public List<TodoItem> loadTodos() throws IOException {
        //loads todos in csv format

        return null;
    }
}
