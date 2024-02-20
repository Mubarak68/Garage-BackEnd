package com.GarageApp.GarageApp.service.category;

import com.GarageApp.GarageApp.Entity.CategoryEntity;
import com.GarageApp.GarageApp.bo.category.CreateCategoryRequest;
import com.GarageApp.GarageApp.repository.CategoryRepository;
import com.GarageApp.GarageApp.util.enums.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryEntity> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public void addCategory(CreateCategoryRequest createCategoryRequest) {
        CategoryEntity category = new CategoryEntity();
        category.setCategoryName(Category.valueOf(createCategoryRequest.getCategoryName()));
        categoryRepository.save(category);
    }
}
