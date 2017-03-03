package com.javashop.model;

import java.util.ArrayList;
import java.util.List;

public class CategoryEntity {
    private Integer id;
    private String name;
    private int parentId;
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
}


