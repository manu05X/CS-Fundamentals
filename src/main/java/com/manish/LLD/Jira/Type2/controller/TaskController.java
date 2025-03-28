package com.manish.LLD.Jira.Type2.controller;

import com.manish.LLD.Jira.Type2.exception.ResourceNotFoundException;
import com.manish.LLD.Jira.Type2.model.Task;
import com.manish.LLD.Jira.Type2.model.User;
import com.manish.LLD.Jira.Type2.service.TaskService;
/*
@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public Task createTask(@RequestBody TaskRequest request, @RequestAttribute User currentUser) {
        User reporter = request.getReporterId() != null ?
                getUserById(request.getReporterId()) : currentUser;

        return taskService.createTask(
                request.getTitle(),
                request.getDescription(),
                request.getType(),
                currentUser,
                reporter
        );
    }

    @PostMapping("/subtasks")
    public Subtask createSubtask(@RequestBody SubtaskRequest request, @RequestAttribute User currentUser) {
        Task parentTask = getTaskById(request.getParentTaskId());
        User reporter = request.getReporterId() != null ?
                getUserById(request.getReporterId()) : currentUser;

        return taskService.createSubtask(
                request.getTitle(),
                request.getDescription(),
                request.getType(),
                currentUser,
                reporter,
                parentTask
        );
    }

    @PutMapping("/{taskId}/status")
    public Task updateTaskStatus(@PathVariable int taskId, @RequestBody StatusUpdateRequest request,
                                 @RequestAttribute User currentUser) {
        taskService.updateTaskStatus(taskId, request.getNewStatus(), currentUser);
        return getTaskById(taskId);
    }

    // Other endpoints for sprints, assignments, etc.

    private User getUserById(int userId) {
        // Implementation would typically use UserRepository
        throw new ResourceNotFoundException("User not found");
    }

    private Task getTaskById(int taskId) {
        // Implementation would typically use TaskRepository
        throw new ResourceNotFoundException("Task not found");
    }
}

 */