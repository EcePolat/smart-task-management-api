package com.ecepolat.dto.task;

import com.ecepolat.enums.Priority;

import java.time.LocalDate;

public record TaskUpdateRequestDto(
        String title,
        String description,
        Priority priority,
        LocalDate dueDate,
        Long categoryId) {
}
