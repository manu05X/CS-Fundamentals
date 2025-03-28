package com.manish.LLD.Jira.Type2.model;

import com.manish.LLD.Jira.Type2.constants.Enums;

public class Subtask extends Task{
    private Task parentTask;
    public Subtask(int taskId, String title, String description, Enums.TaskType type,
                   User createdBy, User reporter, Task parentTask) {
        super(taskId, title, description, type, createdBy, reporter);
        this.parentTask = parentTask;
    }

    public Task getParentTask() { return parentTask; }
}
