package com.example.ecommerce_apis.controller;

import com.example.ecommerce_apis.entity.Category;
import com.example.ecommerce_apis.entity.Product;
import com.example.ecommerce_apis.model.CategoryModel;
import com.example.ecommerce_apis.service.CategoryService;
import com.example.ecommerce_apis.service.impl.CategoryServiceImpl;
import org.apache.logging.log4j.util.PerformanceSensitive;
import org.apache.logging.log4j.util.PropertiesPropertySource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping()
    public CategoryModel createCategory(@RequestBody CategoryModel categoryModel)
    {
        CategoryModel category = categoryService.create(categoryModel);
        return category;
//        String status = categoryService.create(newCategory);
//        return new ResponseEntity<>(status, HttpStatus.CREATED);
    }
    @PutMapping()
    public CategoryModel updateCategory(@RequestBody CategoryModel categoryModel)
    {
        CategoryModel updatedCategory = categoryService.update(categoryModel);
        return updatedCategory;

    }
    @PostMapping("/activate")
    public CategoryModel activateCategory(@RequestParam Long id)
    {
        CategoryModel activatedCategory = categoryService.activateCategory(id);
        return activatedCategory;
    }
    @PostMapping("/deactivate")
    public CategoryModel deactivateCategory(@RequestParam Long id)
    {
        CategoryModel deactivatedCategory = categoryService.deactivateCategory(id);
        return deactivatedCategory;
    }
    @GetMapping("/listAll")
    public ResponseEntity<List<CategoryModel>> getAllCategories() {
        List<CategoryModel> allCategories = categoryService.listAll();
        return new ResponseEntity<>(allCategories, HttpStatus.OK);
    }
    @GetMapping()
    public ResponseEntity<CategoryModel> getCategoryById(@RequestParam Long id) {
        CategoryModel category = categoryService.findById(id);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }
    @GetMapping("/name")
    public ResponseEntity<CategoryModel> getCategoryByName(@RequestParam String name) {
        CategoryModel category = categoryService.findByName(name);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }
    @DeleteMapping()
    public void deleteCategoryByName(@RequestParam String name)
    {
        categoryService.deleteByName(name);
    }


}
