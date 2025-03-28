package com.manish.LLD.Jira.Type2.dto.request;

import com.manish.LLD.Jira.Type2.constants.Enums;

public class StatusUpdateRequest {
    private Enums.TaskStatus newStatus;
    
    // Getters and Setters
    public Enums.TaskStatus getNewStatus() { return newStatus; }
    public void setNewStatus(Enums.TaskStatus newStatus) { this.newStatus = newStatus; }
}