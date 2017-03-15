package com.javashop.model;

import java.util.ArrayList;
import java.util.List;

public class CategoryEntity {
    private Integer id;
    private String name;
    private int parentId;
    private CategoryEntity parentCategory;
    private List<CategoryEntity> subCategories;


    public CategoryEntity(){
        subCategories = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CategoryEntity getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(CategoryEntity parentCategory) {
        this.parentCategory = parentCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public List<CategoryEntity> getSubCategories() {
        return subCategories;
    }

    public static List<CategoryEntity> splitCategories(List<CategoryEntity> categories){
        for (int i = 0; i < categories.size(); i++) {
            for (int j = i; j < categories.size();j++) {
                if(categories.get(j).getParentId() !=0 && categories.get(j).getParentId() == categories.get(i).getId() ) {
                    categories.get(i).getSubCategories().add(categories.get(j));
                }
            }
        }
        return categories;
    }
}


