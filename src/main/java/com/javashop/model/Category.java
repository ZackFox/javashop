package com.javashop.model;

import java.util.ArrayList;
import java.util.List;

public class Category {
    private Integer id;
    private String name;
    private int parentId;
    private Category parentCategory;
    private List<Category> subCategories;


    public Category(){
        subCategories = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Category getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(Category parentCategory) {
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

    public List<Category> getSubCategories() {
        return subCategories;
    }

    public static List<Category> splitCategories(List<Category> categories){
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


