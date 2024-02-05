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

    public int listDoneTodos() throws IOException {
        List<TodoItem> todos = storage.loadTodos();
        todos.stream()
                .filter(TodoItem::isDone)
                .forEach(todo -> System.out.println("- " + todo));
        return 0;
    }

    public int markTodoAsDone(String name) throws IOException {
        List<TodoItem> todos = storage.loadTodos();
        todos.stream()
                .filter(todo -> todo.getName().equals(name))
                .forEach(TodoItem::markAsDone);
        storage.saveTodos(todos);
        return 0;
    }
}
