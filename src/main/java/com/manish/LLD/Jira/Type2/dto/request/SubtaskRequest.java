package com.manish.LLD.Jira.Type2.dto.request;

public class SubtaskRequest extends CreateTaskRequest {
    private int parentTaskId;
    
    // Getters and Setters
    public int getParentTaskId() { return parentTaskId; }
    public void setParentTaskId(int parentTaskId) { this.parentTaskId = parentTaskId; }
}