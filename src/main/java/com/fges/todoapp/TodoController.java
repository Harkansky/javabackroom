package com.fges.todoapp;

import java.io.IOException;
import java.util.List;

public class TodoController {
    private final DataStorage storage;

    public TodoController(DataStorage storage) {
        this.storage = storage;
    }

    public int insertTodo(String name) throws IOException {
        List<TodoItem> todos = storage.loadTodos();
        todos.add(new TodoItem(name));
        storage.saveTodos(todos);
        return 0;
    }

    public int listTodos() throws IOException {
        List<TodoItem> todos = storage.loadTodos();
        todos.forEach(todo -> System.out.println("- " + todo));
        return 0;
    }
}
