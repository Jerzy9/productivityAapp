package com.example.todo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

public class Task {
    private final UUID id;
    private final String name;
    private final String text;

    public Task(@JsonProperty("id") UUID id, @JsonProperty("name") String name, @JsonProperty("text") String text) {
        this.id = id;
        this.name = name;
        this.text = text;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }
}
