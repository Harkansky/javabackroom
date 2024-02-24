package com.fges.todoapp;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.MissingNode;

import java.io.IOException;

public class JsonTodoController implements TodoController {
    @Override
    public void insertTodo(String fileName, TodoItem todo) throws IOException {
        String fileContent = StorageController.readFileContent(fileName);

        ObjectMapper mapper = new ObjectMapper();
        JsonNode actualObj = mapper.readTree(fileContent);
        if (actualObj instanceof MissingNode) {
            actualObj = JsonNodeFactory.instance.arrayNode();
        }

        if (actualObj instanceof ArrayNode arrayNode) {
            arrayNode.add(mapper.valueToTree(todo));
        }

        StorageController.writeToFile(fileName, actualObj.toString());
    }

    @Override
    public void listTodos(String fileName, boolean showDone) throws IOException {
        String fileContent = StorageController.readFileContent(fileName);

        ObjectMapper mapper = new ObjectMapper();
        JsonNode actualObj = mapper.readTree(fileContent);
        if (actualObj instanceof MissingNode) {
            actualObj = JsonNodeFactory.instance.arrayNode();
        }

        if (actualObj instanceof ArrayNode arrayNode) {
            arrayNode.forEach(node -> {
                TodoItem todo = mapper.convertValue(node, TodoItem.class);
                if (!showDone || todo.isDone()) {
                    if (todo.isDone()) {
                        System.out.print("- Done: " + todo.getName());
                    } else {
                        System.out.print("- " + todo.getName());
                    }
                    if (node != arrayNode.get(arrayNode.size() - 1)) {
                        System.out.print(", ");
                    }
                }
            });
        }
    }

    @Override
    public void migrate(String from, String to) throws IOException {
        String fileContent = StorageController.readFileContent(from);
        StorageController.writeToFile(to, fileContent);
    }
}