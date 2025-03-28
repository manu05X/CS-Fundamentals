package com.manish.LLD.Jira.Type1;

import com.manish.LLD.Jira.Type1.model.Task;
import com.manish.LLD.Jira.Type1.model.TaskStatus;
import com.manish.LLD.Jira.Type1.model.TaskType;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final String name;
    private final List<Task> taskList;
    private final List<Sprint> sprintList;

    public User(String name) {
        this.name = name;
        this.taskList = new ArrayList<>();
        this.sprintList = new ArrayList<>();
    }

    public Task createTask(TaskType taskType) {
        Task task = new Task();
        task.setTaskType(taskType);
        task.setUser(this);
        taskList.add(task);
        return task;
    }

    public Task createTask(String description) {
        Task task = new Task();
        task.setTaskType(TaskType.STORY);
        task.setUser(this);
        task.setDescription(description);
        taskList.add(task);
        return task;
    }

    public Sprint createSprint(int begin, int end, String name) {
        Sprint sprint = new Sprint(begin, end, name);
        sprintList.add(sprint);
        return sprint;
    }

    public boolean addToSprint(Sprint sprint, Task task) {
        if (sprintList.contains(sprint)) {
            sprint.addTask(task);
            return true;
        }
        return false;
    }

    public boolean removeFromSprint(Sprint sprint, Task task) {
        if (sprintList.contains(sprint)) {
            sprint.removeTask(task);
            return true;
        }
        return false;
    }

    public void printAllTasks() {
        for (Task task : taskList) {
            System.out.println(this.name + " " + task);
        }
    }

    public boolean changeStatus(Task task, TaskStatus taskStatus) {
        for (Task t : taskList) {
            if (t.getId() == task.getId()) {
                t.setTaskStatus(taskStatus);
                return true;
            }
        }
        return false;
    }
}
