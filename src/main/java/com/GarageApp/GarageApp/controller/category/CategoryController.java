package com.GarageApp.GarageApp.controller.category;

import com.GarageApp.GarageApp.Entity.CategoryEntity;
import com.GarageApp.GarageApp.Entity.GarageEntity;
import com.GarageApp.GarageApp.bo.category.CreateCategoryRequest;
import com.GarageApp.GarageApp.service.category.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    @GetMapping("/category")
    public ResponseEntity<List<CategoryEntity>> getAllCategories() {
        List<CategoryEntity> allCategories = categoryService.getAllCategories();
        return ResponseEntity.ok(allCategories);
    }

    @PostMapping("/add-category")
    public ResponseEntity<String> addCategory(@RequestBody CreateCategoryRequest createCategoryRequest){
        categoryService.addCategory(createCategoryRequest);
        return ResponseEntity.ok("Category has been added!!");
    }
}
