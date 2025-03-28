package com.manish.LLD.Jira.Type2.constants;

public class Enums {
    public enum TaskType {
        BUG, STORY, FEATURE
    }

    public enum TaskStatus {
        OPEN, IN_PROGRESS, CLOSED
    }

    public enum Role {
        ADMIN,
        DEVELOPER,
        PRODUCT_OWNER,
        SCRUM_MASTER
    }
}
