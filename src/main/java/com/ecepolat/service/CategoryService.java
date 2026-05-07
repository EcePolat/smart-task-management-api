package com.ecepolat.service;

import com.ecepolat.dto.category.CategoryCreateRequestDto;
import com.ecepolat.dto.category.CategoryResponseDto;
import com.ecepolat.dto.category.CategoryUpdateRequestDto;
import com.ecepolat.entity.User;

import java.util.List;

public interface CategoryService {
    CategoryResponseDto createCategory(User user, CategoryCreateRequestDto request);

    List<CategoryResponseDto> getAllCategories(User user);

    CategoryResponseDto updateCategory(Long id, CategoryUpdateRequestDto request);

    void deleteCategory(Long id);

}
