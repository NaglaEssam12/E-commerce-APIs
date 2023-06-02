package com.example.ecommerce_apis.service;

import com.example.ecommerce_apis.entity.Category;
import com.example.ecommerce_apis.entity.Product;
import com.example.ecommerce_apis.model.CategoryModel;

import java.util.List;

public interface CategoryService{
    CategoryModel create(CategoryModel category);
    CategoryModel update(CategoryModel category);
    CategoryModel activateCategory(Long id);
    CategoryModel deactivateCategory(Long id);
    List<CategoryModel> listAll();
    void deleteByName(String name) ;
    CategoryModel findByName(String name);
    CategoryModel findById(Long id);
    //activate
    //deactivate


}
