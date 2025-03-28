package com.manish.LLD.Jira.Type1;

import com.manish.LLD.Jira.Type1.model.Task;
import java.util.ArrayList;
import java.util.List;

public class Sprint {
    private static int uniqueId = 1;
    private final int sprintId;
    private final String name;
    private final int begin;
    private final int end;
    private final List<Task> taskList;

    public Sprint(int begin, int end, String name) {
        this.sprintId = uniqueId++;
        this.begin = begin;
        this.end = end;
        this.name = name;
        this.taskList = new ArrayList<>();
    }

    public void addTask(Task task) {
        taskList.add(task);
    }

    public void removeTask(Task task) {
        taskList.remove(task);
    }

    public List<Task> getTasks() {
        return new ArrayList<>(taskList);
    }

    public void printDetails() {
        System.out.println("Sprint " + this.name + " begins at " + this.begin + " ends at " + this.end);
    }
}