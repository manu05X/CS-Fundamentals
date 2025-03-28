package com.manish.LLD.Jira.Type2.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class Sprint {
    private int sprintId;
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private User createdBy;
    private Team team;
    private Set<Task> tasks = new HashSet<>();

    public Sprint(int sprintId, String name, LocalDate startDate,
                  LocalDate endDate, User createdBy, Team team) {
        this.sprintId = sprintId;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.createdBy = createdBy;
        this.team = team;
    }


    public boolean  addTask(Task task, User user){
        if (!user.canCreateSprint()) {
            return false;
        }
        tasks.add(task);
        task.setSprint(this);

        return true;
    }

    // Getters and Setters
    public int getSprintId() { return sprintId; }
    public String getName() { return name; }
    public LocalDate getStartDate() { return startDate; }
    public LocalDate getEndDate() { return endDate; }
    public User getCreatedBy() { return createdBy; }
    public Team getTeam() { return team; }
    public Set<Task> getTasks() { return tasks; }
}
