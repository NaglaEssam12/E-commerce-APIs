package com.example.ecommerce_apis.service.impl;

import com.example.ecommerce_apis.entity.Product;
import com.example.ecommerce_apis.model.OrderItemsModel;
import com.example.ecommerce_apis.model.ProductModel;
import com.example.ecommerce_apis.repository.ProductRepository;
import com.example.ecommerce_apis.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public ProductModel create(ProductModel productModel) {
        productModel.setActive(true);
        productModel.setShipped(true);
        if(productModel.isService())
            productModel.setShipped(false);
        Product product = Product.toEntity(productModel);
        productRepository.save(product);
        return ProductModel.toModel(product);
    }

    @Override
    public ProductModel update(ProductModel productModel) {
        Product current = productRepository.findById(productModel.getId()).orElseThrow(()-> new RuntimeException());
        if(current != null)
        {
            current.setName(productModel.getName());
            current.setQuantity(productModel.getQuantity());
            current.setPrice(productModel.getPrice());
            current.setActive(productModel.isActive());
            current.setCategory(productModel.getCategory());
            current.setService(productModel.isService());
            current.setShipped(true);
            if(productModel.isService())
                current.setShipped(false);
            productRepository.save(current);
            return ProductModel.toModel(current);
        }
        return null;
    }
    @Override
    public ProductModel activiateProduct(Long id) {
        Product current = productRepository.findById(id).orElse(null);
        if(current != null) {
            current.setActive(true);
            productRepository.save(current);
            return ProductModel.toModel(current);
        }
        return null;
    }

    @Override
    public ProductModel deactiviateProduct(Long id) {
        Product current = productRepository.findById(id).orElse(null);
        if(current != null) {
            current.setActive(false);
            productRepository.save(current);
            return ProductModel.toModel(current);

        }
        return null;
    }
    @Override
    public List<ProductModel> listAll() {
        return productRepository.findAll()
                .stream()
                .map(product -> ProductModel.toModel(product))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        productRepository.findById(id);
    }

    @Override
    public List<ProductModel> findByCategory(Long id) {
        return productRepository.findByCategory(id)
                .stream()
                .map(product->ProductModel.toModel(product))
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductModel> findByPriceRange(Double lowRange, Double highRange) {
        return productRepository.findByPriceRange(lowRange, highRange)
                .stream()
                .map(product->ProductModel.toModel(product))
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductModel> findByCategoryAndPriceRange(Long id, Double lowPrice, Double highPrice) {
        return  productRepository.findByCategoryAndPriceRange(id,lowPrice, highPrice)
                .stream()
                .map(product->ProductModel.toModel(product))
                .collect(Collectors.toList());
    }
    @Override
    public ProductModel findProduct(OrderItemsModel orderItemsModel)
    {
        Product product = productRepository.findById(orderItemsModel.getProduct().getId()).orElse(null);
        ProductModel productModel = ProductModel.toModel(product);
        return  productModel;
    }
    @Override
    public Double getProductPrice(OrderItemsModel orderItemsModel)
    {
        Double productPrice = 0.0;
        ProductModel productModel = findProduct(orderItemsModel);
        if(productModel != null)
            productPrice = productModel.getPrice();
        return productPrice;
    }
    @Override
    public void updateProductQuantity(OrderItemsModel orderItemsModel){
        Product product = productRepository.findById(orderItemsModel.getProduct().getId()).orElse(null);
        ProductModel productModel = ProductModel.toModel(product);
        Long productQuantity = productModel.getQuantity() ;
        if(productModel != null) {
            productQuantity -= orderItemsModel.getQuantity();
            productModel.setQuantity(productQuantity);
            productRepository.save(Product.toEntity(productModel));
        }
    }


}
