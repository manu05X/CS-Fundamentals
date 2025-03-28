package com.manish.LLD.Jira.Type1.model;

import com.manish.LLD.Jira.Type1.User;

public class SubTask {
    private static int uniqueId = 1;
    private final int id;
    private String description;
    private User user;
    private TaskType taskType;
    private TaskStatus taskStatus;

    public SubTask() {
        this.id = uniqueId++;
        this.taskStatus = TaskStatus.OPEN;
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
}