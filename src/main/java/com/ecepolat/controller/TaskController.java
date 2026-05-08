package com.ecepolat.controller;

import com.ecepolat.common.response.RootEntity;
import com.ecepolat.dto.task.TaskCreateRequestDto;
import com.ecepolat.dto.task.TaskResponseDto;
import com.ecepolat.dto.task.TaskStatusUpdateRequestDto;
import com.ecepolat.dto.task.TaskUpdateRequestDto;
import com.ecepolat.entity.User;
import com.ecepolat.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController extends RestBaseController{

    private final TaskService taskService;

    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    @PostMapping
    public RootEntity<TaskResponseDto> createTask(@Valid @RequestBody TaskCreateRequestDto request){
        return ok(taskService.createTask(request));
    }

    @GetMapping("/")
    public RootEntity<List<TaskResponseDto>> getAllTask(@AuthenticationPrincipal User user){
        return ok(taskService.getAllTask(user));
    }

    @GetMapping("/{id}")
    public RootEntity<TaskResponseDto> getTaskById(@PathVariable Long id){
        return ok(taskService.getTaskById(id));
    }

    @PutMapping("/{id}")
    public RootEntity<TaskResponseDto> updateTask(@Valid @PathVariable Long id,
                                                  @RequestBody TaskUpdateRequestDto request){
        return ok(taskService.updateTask(id, request));
    }

    @PatchMapping("/{id}/status")
    public RootEntity<TaskResponseDto> updateTaskStatus(@Valid @PathVariable Long id,
                                                        @RequestBody TaskStatusUpdateRequestDto request){
        return ok(taskService.updateTaskStatus(id, request));
    }

    @DeleteMapping("/{id}")
    public RootEntity<String> deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
        return ok("Task başarıyla silindi.");
    }
}
