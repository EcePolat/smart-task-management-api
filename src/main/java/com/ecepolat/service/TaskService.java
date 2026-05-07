package com.ecepolat.service;

import com.ecepolat.dto.task.TaskCreateRequestDto;
import com.ecepolat.dto.task.TaskResponseDto;
import com.ecepolat.dto.task.TaskStatusUpdateRequestDto;
import com.ecepolat.dto.task.TaskUpdateRequestDto;
import com.ecepolat.entity.User;

import java.util.List;

public interface TaskService {

    TaskResponseDto createTask(TaskCreateRequestDto request);

    List<TaskResponseDto> getAllTask(User user);

    TaskResponseDto getTaskById(Long id);

    TaskResponseDto updateTask(Long id, TaskUpdateRequestDto request);

    TaskResponseDto updateTaskStatus(Long id, TaskStatusUpdateRequestDto request);

    void deleteTask(Long id);
}
