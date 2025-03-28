package com.manish.LLD.Jira.Type1;

import com.manish.LLD.Jira.Type1.model.Task;
import com.manish.LLD.Jira.Type1.model.TaskStatus;
import com.manish.LLD.Jira.Type1.model.TaskType;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("Raj");
        User user2 = new User("Rahul");
        Task task1 = user1.createTask(TaskType.FEATURE);
        Task task11 = user1.createTask(TaskType.BUG);
        Task task2 = user2.createTask(TaskType.BUG);
        Task task22 = user2.createTask("This is a task description");

        Sprint sprint1 = user1.createSprint(22, 33, "Sprint1");
        Sprint sprint2 = user2.createSprint(44, 55, "Sprint2");

        System.out.println(user1.changeStatus(task11, TaskStatus.IN_PROGRESS));

        System.out.println(user1.addToSprint(sprint1, task1));
        System.out.println(user1.addToSprint(sprint1, task11));
        System.out.println(user1.addToSprint(sprint2, task1));
        System.out.println(user1.removeFromSprint(sprint1, task11));
        System.out.println(user2.addToSprint(sprint1, task1));
        System.out.println(user2.removeFromSprint(sprint1, task2));
        System.out.println(user2.addToSprint(sprint2, task1));
        System.out.println(user2.addToSprint(sprint2, task2));

        sprint1.printDetails();
        System.out.println();
        user1.printAllTasks();
        user2.printAllTasks();
    }
}
