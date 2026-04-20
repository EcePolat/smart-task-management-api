package com.ecepolat.dto.task;

import com.ecepolat.enums.Priority;
import com.ecepolat.enums.TaskStatus;

import java.time.LocalDate;

public record TaskCreateRequestDto(
        String title,
        String description,
        TaskStatus status,
        Priority priority,
        LocalDate dueDate,
        Long categoryId) {
}
