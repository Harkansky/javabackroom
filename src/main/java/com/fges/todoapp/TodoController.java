package com.fges.todoapp;

import java.io.IOException;

public interface TodoController {
    void insertTodo(String fileName, TodoItem todo) throws IOException;
    void listTodos(String fileName, boolean done) throws IOException;

}