package com.fges.todoapp;

public class TodoItem {
    private final String name;

    public TodoItem(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

