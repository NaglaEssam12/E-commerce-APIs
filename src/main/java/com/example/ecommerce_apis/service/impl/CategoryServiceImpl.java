package com.example.ecommerce_apis.service.impl;

import com.example.ecommerce_apis.entity.Category;
import com.example.ecommerce_apis.entity.Product;
import com.example.ecommerce_apis.model.CategoryModel;
import com.example.ecommerce_apis.model.ProductModel;
import com.example.ecommerce_apis.repository.CategoryRepository;
import com.example.ecommerce_apis.repository.ProductRepository;
import com.example.ecommerce_apis.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;

    List<ProductModel> findProductsByCategoryId(Long id)
    {
        List<ProductModel> products = productRepository.findProductsByCategory_Id(id)
                .stream()
                .map(product -> ProductModel.toModel(product))
                .collect(Collectors.toList());
        return products;
    }
    @Override
    public CategoryModel create(CategoryModel categoryModel) {
        categoryModel.setActive(true);
        Category category = Category.toEntity(categoryModel);
        categoryRepository.save(category);
        return CategoryModel.toModel(category);
    }

    @Override
    public CategoryModel update(CategoryModel categoryModel) {
        Category current = categoryRepository.findById(categoryModel.getId()).orElse(null);
        if(current != null)
        {
            current.setName(categoryModel.getName());
            current.setActive(categoryModel.isActive());
            categoryRepository.save(current);
            return CategoryModel.toModel(current);
        }
        return null;
    }
    @Override
    public CategoryModel activateCategory(Long id) {
        Category current = categoryRepository.findById(id).orElse(null);
        if(current != null) {
            current.setActive(true);
            categoryRepository.save(current);

            List<ProductModel> products = findProductsByCategoryId(id);

            products.forEach(productModel -> productModel.setActive(true));
            products.forEach(productModel -> productRepository.save(Product.toEntity(productModel)));

            return CategoryModel.toModel(current);
        }
        return null;
    }

    @Override
    public CategoryModel deactivateCategory(Long id) {
        Category current = categoryRepository.findById(id).orElse(null);
        if(current != null) {
            current.setActive(false);
            categoryRepository.save(current);

            List<ProductModel> products = findProductsByCategoryId(id);

            products.forEach(productModel -> productModel.setActive(false));
            products.forEach(productModel -> productRepository.save(Product.toEntity(productModel)));

            return CategoryModel.toModel(current);
        }
        return null;
    }
    @Override
    public List<CategoryModel> listAll() {
        return  categoryRepository.findAll()
                .stream()
                .map(category -> CategoryModel.toModel(category))
                .collect(Collectors.toList());
    }

    //Todo if Category deleted, I should delete all its products
    @Override
    public void deleteByName(String name) {
        categoryRepository.deleteCategoryByName(name);
    }

    @Override
    public CategoryModel findByName(String name) {
        return CategoryModel.toModel(categoryRepository.findByName(name));
    }

    @Override
    public CategoryModel findById(Long id) {
        return CategoryModel.toModel(categoryRepository.findById(id).orElse(null));
    }
}
