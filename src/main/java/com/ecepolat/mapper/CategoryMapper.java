package com.ecepolat.mapper;

import com.ecepolat.dto.category.CategoryResponseDto;
import com.ecepolat.entity.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {
    public CategoryResponseDto toResponseDto(Category category){
        return new CategoryResponseDto(
                category.getId(),
                category.getName()
        );
    }
}
