package com.fges.todoapp;

import java.io.IOException;
import java.util.List;
public interface DataStorage {
    void saveTodos(List<TodoItem> todos) throws IOException;
    List<TodoItem> loadTodos() throws IOException;
}
