package com.manish.LLD.Jira.Type2.service.impl;

import com.manish.LLD.Jira.Type2.constants.Enums;
import com.manish.LLD.Jira.Type2.exception.ResourceNotFoundException;
import com.manish.LLD.Jira.Type2.exception.UnauthorizedException;
import com.manish.LLD.Jira.Type2.model.*;
import com.manish.LLD.Jira.Type2.service.TaskService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TaskServiceImpl implements TaskService {
    private List<Task> tasks = new ArrayList<>();
    private List<Sprint> sprints = new ArrayList<>();
    private List<User> users = new ArrayList<>();
    private List<Team> teams = new ArrayList<>();
    private int taskIdCounter = 1;
    private int sprintIdCounter = 1;

    @Override
    public Task createTask(String title, String description, Enums.TaskType type,
                           User creator, User reporter) {
        if (!creator.canCreateTask()) {
            throw new UnauthorizedException("User not authorized to create tasks");
        }

        Task task = new Task(taskIdCounter++, title, description, type, creator, reporter);
        tasks.add(task);
        return task;
    }

    @Override
    public Subtask createSubtask(String title, String description, Enums.TaskType type,
                                 User creator, User reporter, Task parentTask) {
        if (!creator.canCreateTask()) {
            throw new UnauthorizedException("User not authorized to create subtasks");
        }

        Subtask subtask = new Subtask(taskIdCounter++, title, description, type, creator, reporter, parentTask);
        parentTask.addSubtask(subtask);
        tasks.add(subtask);
        return subtask;
    }

    @Override
    public void updateTaskStatus(int taskId, Enums.TaskStatus newStatus, User user) {
        Task task = findTaskById(taskId);
        if (task == null) {
            throw new ResourceNotFoundException("Task not found");
        }

        // Only assignee or admin can update status
        if (task.getAssignee() == null ||
                (!task.getAssignee().equals(user) && user.getRole() != Enums.Role.ADMIN)) {
            throw new UnauthorizedException("User not authorized to update this task");
        }

        task.setStatus(newStatus);
    }

    @Override
    public Sprint createSprint(String name, LocalDate startDate, LocalDate endDate,
                               Team team, User creator) {
        if (!creator.canCreateSprint()) {
            throw new UnauthorizedException("User not authorized to create sprints");
        }

        Sprint sprint = new Sprint(sprintIdCounter++, name, startDate, endDate, creator, team);
        sprints.add(sprint);
        return sprint;
    }

    @Override
    public boolean addTaskToSprint(int sprintId, int taskId, User user) {
        Sprint sprint = findSprintById(sprintId);
        Task task = findTaskById(taskId);

        if (sprint == null || task == null) {
            throw new ResourceNotFoundException("Sprint or Task not found");
        }

        return sprint.addTask(task, user);
    }

    @Override
    public List<Task> getDelayedTasks() {
        LocalDate today = LocalDate.now();
        return sprints.stream()
                .filter(s -> s.getEndDate().isBefore(today))
                .flatMap(s -> s.getTasks().stream())
                .filter(t -> t.getStatus() != Enums.TaskStatus.CLOSED)
                .collect(Collectors.toList());
    }

    @Override
    public List<Task> getUserTasks(int userId) {
        return tasks.stream()
                .filter(t -> t.getAssignee() != null && t.getAssignee().getUserId() == userId)
                .collect(Collectors.toList());
    }

    @Override
    public void printSprintDetails(int sprintId, User user) {
        Sprint sprint = findSprintById(sprintId);
        if (sprint == null) {
            throw new ResourceNotFoundException("Sprint not found");
        }

        // Check if user is in the sprint's team
        if (!sprint.getTeam().getMembers().contains(user)) {
            throw new UnauthorizedException("User not authorized to view this sprint");
        }

        System.out.println("Sprint: " + sprint.getName());
        System.out.println("Team: " + sprint.getTeam().getName());
        System.out.println("Period: " + sprint.getStartDate() + " to " + sprint.getEndDate());
        System.out.println("Tasks:");
        sprint.getTasks().forEach(task -> {
            System.out.println("- " + task.getTitle() +
                    " (" + task.getStatus() + ")" +
                    " - Assignee: " + (task.getAssignee() != null ?
                    task.getAssignee().getName() : "Unassigned"));
        });
    }

    private Task findTaskById(int taskId) {
        return tasks.stream().filter(t -> t.getTaskId() == taskId).findFirst().orElse(null);
    }

    private Sprint findSprintById(int sprintId) {
        return sprints.stream().filter(s -> s.getSprintId() == sprintId).findFirst().orElse(null);
    }
}
