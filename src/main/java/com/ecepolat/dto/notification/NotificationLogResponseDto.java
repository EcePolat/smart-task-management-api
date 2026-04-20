package com.ecepolat.dto.notification;

import com.ecepolat.enums.NotificationType;

import java.time.LocalDateTime;

public record NotificationLogResponseDto(
        Long id,
        NotificationType type,
        String message,
        LocalDateTime sentAt,
        Long taskId) {
}
