package com.ceica.modelos;

import java.sql.Timestamp;

public class Task {
    private String title, description, status;
    private Timestamp creation_time, deadline;

    public Task() {
    }

    public Task(String title, String description, String status, Timestamp deadline) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.creation_time = new Timestamp(System.currentTimeMillis());
        this.deadline = deadline;
    }
}
