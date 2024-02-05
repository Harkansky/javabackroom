package com.fges.todoapp;

public class TodoItem {
    private final String name;
    private boolean done = false;

    public TodoItem(String name) {
        this.name = name;
    }

    public void markAsDone() {
        done = true;
    }

    public boolean isDone() {
        return done;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}

