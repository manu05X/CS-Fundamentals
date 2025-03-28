package com.manish.LLD.Jira.Type1.model;

import com.manish.LLD.Jira.Type1.User;

import java.util.ArrayList;
import java.util.List;

public class Task {
    private static int uniqueId = 1;
    private final int id;
    private final List<SubTask> subTaskList;
    private User user;
    private String description;
    private TaskStatus taskStatus;
    private TaskType taskType;

    public Task() {
        this.id = uniqueId++;
        this.taskStatus = TaskStatus.OPEN;
        this.subTaskList = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }

    public void setTaskType(TaskType taskType) {
        this.taskType = taskType;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", status=" + taskStatus +
                ", type=" + taskType +
                '}';
    }
}