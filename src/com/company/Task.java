package com.company;

public class Task {
    private String id;
    private String task;
    private boolean isDone;

    public Task(String id, String task, boolean isDone) {
        this.id = id;
        this.task = task;
        this.isDone = isDone;
    }

    public Task() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id='" + id + '\'' +
                ", task='" + task + '\'' +
                ", isDone=" + isDone +
                '}';
    }
}

