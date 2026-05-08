package com.ecepolat.service.impl;

import com.ecepolat.dto.category.CategoryCreateRequestDto;
import com.ecepolat.dto.category.CategoryResponseDto;
import com.ecepolat.dto.category.CategoryUpdateRequestDto;
import com.ecepolat.entity.Category;
import com.ecepolat.entity.User;
import com.ecepolat.exception.BusinessException;
import com.ecepolat.exception.ErrorCode;
import com.ecepolat.mapper.CategoryMapper;
import com.ecepolat.repository.CategoryRepository;
import com.ecepolat.repository.UserRepository;
import com.ecepolat.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;
    private final CategoryMapper categoryMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository,
                               UserRepository userRepository,
                               CategoryMapper categoryMapper){
        this.categoryRepository = categoryRepository;
        this.userRepository = userRepository;
        this.categoryMapper = categoryMapper;
    }

    private Category findByCategoryId(Long id){
        return categoryRepository.findById(id)
                .orElseThrow(() -> new BusinessException(ErrorCode.CATEGORY_NOT_FOUND));
    }

    @Override
    public CategoryResponseDto createCategory(User user, CategoryCreateRequestDto request) {

        if(categoryRepository.existsByNameAndUserId(request.name(), user.getId())){
            throw new BusinessException(ErrorCode.CATEGORY_ALREADY_EXISTS);
        }

        Category category = new Category();

        category.setName(request.name());
        category.setUser(user);

        Category savedCategory = categoryRepository.save(category);
        return categoryMapper.toResponseDto(savedCategory);
    }

    @Override
    public List<CategoryResponseDto> getAllCategories(User user) {

        return categoryRepository.findByUserId(user.getId())
                .stream()
                .map(categoryMapper :: toResponseDto)
                .toList();
    }

    @Override
    public CategoryResponseDto updateCategory(Long id, CategoryUpdateRequestDto request) {
        Category category = findByCategoryId(id);

        category.setName(request.name());

        Category updatedCategory = categoryRepository.save(category);
        return categoryMapper.toResponseDto(updatedCategory);
    }

    @Override
    public void deleteCategory(Long id) {
        Category category = findByCategoryId(id);
        categoryRepository.delete(category);
    }
}
