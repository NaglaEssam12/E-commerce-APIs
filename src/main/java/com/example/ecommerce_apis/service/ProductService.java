package com.example.ecommerce_apis.service;

import com.example.ecommerce_apis.entity.Category;
import com.example.ecommerce_apis.entity.Product;
import com.example.ecommerce_apis.model.OrderItemsModel;
import com.example.ecommerce_apis.model.ProductModel;

import java.util.List;

public interface ProductService {
    ProductModel create(ProductModel product);

    ProductModel update(ProductModel product);

    //activate
    ProductModel activiateProduct(Long id);

    //deactivate
    ProductModel deactiviateProduct(Long id);

    List<ProductModel> listAll();

    void deleteById(Long id);

    List<ProductModel> findByCategory(Long id);

    List<ProductModel> findByPriceRange(Double lowRange, Double highRange);

    List<ProductModel> findByCategoryAndPriceRange(Long id, Double lowPrice, Double highPrice);
    ProductModel findProduct(OrderItemsModel orderItemsModel);
    Double getProductPrice(OrderItemsModel orderItemsModel);
    void updateProductQuantity(OrderItemsModel orderItemsModel);
}

