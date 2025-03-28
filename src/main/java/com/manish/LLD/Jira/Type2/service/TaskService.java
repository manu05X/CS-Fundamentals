package com.manish.LLD.Jira.Type2.service;


import com.manish.LLD.Jira.Type2.constants.Enums;
import com.manish.LLD.Jira.Type2.model.*;

import java.time.LocalDate;
import java.util.List;

public interface TaskService {
    Task createTask(String title, String description, Enums.TaskType type, User creator, User reporter);
    Subtask createSubtask(String title, String description, Enums.TaskType type, User creator, User reporter, Task parentTask);
    void updateTaskStatus(int taskId, Enums.TaskStatus newStatus, User user);
    Sprint createSprint(String name, LocalDate startDate, LocalDate endDate, Team team, User creator);
    boolean addTaskToSprint(int sprintId, int taskId, User user);
    List<Task> getDelayedTasks();
    List<Task> getUserTasks(int userId);
    void printSprintDetails(int sprintId, User user);
}
