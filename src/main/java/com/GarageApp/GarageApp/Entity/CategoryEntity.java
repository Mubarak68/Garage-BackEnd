package com.GarageApp.GarageApp.Entity;

import com.GarageApp.GarageApp.util.enums.Category;

import javax.persistence.*;

@Entity
@Table(name = "garage_category")
public class CategoryEntity {

    @Id
    @Column(name = "categoryId", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;

    @Column(name = "categoryName", nullable = false)
    @Enumerated(EnumType.STRING)
    private Category categoryName;

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Category getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(Category categoryName) {
        this.categoryName = categoryName;
    }
}
