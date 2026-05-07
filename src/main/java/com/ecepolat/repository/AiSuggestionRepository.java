package com.ecepolat.repository;

import com.ecepolat.entity.AiSuggestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AiSuggestionRepository extends JpaRepository<AiSuggestion, Long> {
}
