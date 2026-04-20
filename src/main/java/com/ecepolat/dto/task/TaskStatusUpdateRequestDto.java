package com.ecepolat.dto.task;

import com.ecepolat.enums.TaskStatus;

public record TaskStatusUpdateRequestDto(TaskStatus status) {
}
