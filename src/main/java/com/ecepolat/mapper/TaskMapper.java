package com.ecepolat.mapper;

import com.ecepolat.dto.task.TaskResponseDto;
import com.ecepolat.entity.Task;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {

    public TaskResponseDto toResponseDto(Task task){
        return new TaskResponseDto(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getStatus(),
                task.getPriority(),
                task.getDueDate(),
                task.getCreatedAt(),
                task.getUpdatedAt(),
                task.getUser().getId(),
                task.getCategory() != null ? task.getCategory().getId() : null
        );
    }
}
