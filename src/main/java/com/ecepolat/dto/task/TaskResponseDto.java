package com.ecepolat.dto.task;

import com.ecepolat.enums.Priority;
import com.ecepolat.enums.TaskStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record TaskResponseDto(
        Long id,
        String title,
        String description,
        TaskStatus status,
        Priority priority,
        LocalDate dueDate,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        Long userId,
        Long categoryId) {
}
