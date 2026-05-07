package com.ecepolat.controller;

import com.ecepolat.common.response.RootEntity;
import com.ecepolat.dto.category.CategoryCreateRequestDto;
import com.ecepolat.dto.category.CategoryResponseDto;
import com.ecepolat.dto.category.CategoryUpdateRequestDto;
import com.ecepolat.entity.User;
import com.ecepolat.service.CategoryService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController extends RestBaseController{

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @PostMapping("")
    public RootEntity<CategoryResponseDto> createCategory(@AuthenticationPrincipal User user,
                                                          @RequestBody CategoryCreateRequestDto request){
        return ok(categoryService.createCategory(user, request));
    }

    @GetMapping("/")
    public RootEntity<List<CategoryResponseDto>> getAllCategories(@AuthenticationPrincipal User user){
        return ok(categoryService.getAllCategories(user));
    }

    @PutMapping("/{id}")
    public RootEntity<CategoryResponseDto> updateCategory(@PathVariable Long id, @RequestBody CategoryUpdateRequestDto request){
        return ok(categoryService.updateCategory(id, request));
    }

    @DeleteMapping("/{id}")
    public RootEntity<String> deleteCategory(@PathVariable Long id){
        categoryService.deleteCategory(id);
        return ok("Kategori başarıyla silindi");
    }
}
