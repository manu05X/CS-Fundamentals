package com.manish.LLD.Jira.Type2.model;

import com.manish.LLD.Jira.Type2.constants.Enums;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Task {
    private int taskId;
    private String title;
    private String description;
    private Enums.TaskType type;
    private Enums.TaskStatus status = Enums.TaskStatus.OPEN;

    private User assignee;
    private User reporter;
    private User createdBy;

    private LocalDateTime createdAt = LocalDateTime.now();
    private Sprint sprint;
    private List<Subtask> subtasks = new ArrayList<>();


    public Task(int taskId, String title, String description, Enums.TaskType type,
                User createdBy, User reporter) {
        this.taskId = taskId;
        this.title = title;
        this.description = description;
        this.type = type;
        this.createdBy = createdBy;
        this.reporter = reporter;
    }


    // Getters and Setters
    public int getTaskId() { return taskId; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public Enums.TaskType getType() { return type; }
    public Enums.TaskStatus getStatus() { return status; }
    public void setStatus(Enums.TaskStatus status) { this.status = status; }
    public User getAssignee() { return assignee; }
    public void setAssignee(User assignee) { this.assignee = assignee; }
    public User getReporter() { return reporter; }
    public User getCreatedBy() { return createdBy; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public Sprint getSprint() { return sprint; }
    public void setSprint(Sprint sprint) { this.sprint = sprint; }
    public List<Subtask> getSubtasks() { return subtasks; }
    public void addSubtask(Subtask subtask) { subtasks.add(subtask); }
}
