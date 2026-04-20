package com.ecepolat.dto.ai;

import com.ecepolat.enums.AiSuggestionType;

import java.time.LocalDateTime;

public record AiSuggestionResponseDto(
        Long id,
        AiSuggestionType type,
        String content,
        LocalDateTime createdAt,
        Long taskId) {
}

