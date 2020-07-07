package com.example.todo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.util.UUID;
public class Task {
    private final UUID id;
    @NotBlank
    private final String name;
    @NotBlank
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
