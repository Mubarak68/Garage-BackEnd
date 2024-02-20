package com.GarageApp.GarageApp.service.category;

import com.GarageApp.GarageApp.Entity.CategoryEntity;
import com.GarageApp.GarageApp.Entity.GarageEntity;
import com.GarageApp.GarageApp.bo.category.CreateCategoryRequest;

import java.util.List;

public interface CategoryService {
    List<CategoryEntity> getAllCategories();

    void addCategory(CreateCategoryRequest createCategoryRequest);
}
