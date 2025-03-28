package com.manish.LLD.Jira.Type2.dto.request;

//public class CreateTaskRequest {
//}


import com.manish.LLD.Jira.Type2.constants.Enums;

public class CreateTaskRequest {
    private String title;
    private String description;
    private Enums.TaskType type;
    private Integer reporterId;

    // Getters and Setters
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Enums.TaskType getType() { return type; }
    public void setType(Enums.TaskType type) { this.type = type; }
    public Integer getReporterId() { return reporterId; }
    public void setReporterId(Integer reporterId) { this.reporterId = reporterId; }
}