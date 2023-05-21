package com.example.ecommerce_apis.controller;

import com.example.ecommerce_apis.entity.Category;
import com.example.ecommerce_apis.entity.Product;
import com.example.ecommerce_apis.model.ProductModel;
import com.example.ecommerce_apis.service.CategoryService;
import com.example.ecommerce_apis.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;
    @PostMapping("/product")
    public ProductModel createProduct(@RequestBody ProductModel productModel)
    {
        ProductModel newProduct = productService.create(productModel);
        return newProduct;
    }
    @PutMapping("/product")
    public ProductModel updateProduct(@RequestBody ProductModel productModel)
    {
        ProductModel updatedProduct = productService.update(productModel);
        return updatedProduct;
    }
    @PostMapping("/product/activate")
    public ProductModel activateProduct(@RequestParam Long id)
    {
        ProductModel activatedProduct = productService.activiateProduct(id);
        return activatedProduct;
    }
    @PostMapping("/product/deactivate")
    public ProductModel deactivateProduct(@RequestParam Long id)
    {
        ProductModel deactivatedProduct = productService.deactiviateProduct(id);
        return deactivatedProduct;
    }
    @GetMapping("/products")
    public ResponseEntity<List<ProductModel>> getAllProducts() {
        List<ProductModel> allProducts = productService.listAll();
        return new ResponseEntity<>(allProducts, HttpStatus.OK);
    }
    @GetMapping("/productsWithCategory")
    public ResponseEntity<List<ProductModel>> getProductByCategory(@RequestParam Long id) {
        List<ProductModel> productsWithCategory= productService.findByCategory(id);
        return new ResponseEntity<>(productsWithCategory, HttpStatus.OK);
    }
    @GetMapping("/productsWithinPriceRange")
    public ResponseEntity<List<ProductModel>> getProductByPriceRange(@RequestParam Double lowPrice,@RequestParam Double highPrice) {
        List<ProductModel> productsWithPrice= productService.findByPriceRange(lowPrice,highPrice);
        return new ResponseEntity<>(productsWithPrice, HttpStatus.OK);
    }
    @GetMapping("/productsWithCategoryAndWithinPriceRange")
    public ResponseEntity<List<ProductModel>> getProductByCategoryAndWithinPriceRange(@RequestParam Long categoryId,
                                                                                 @RequestParam Double lowPrice,@RequestParam Double highPrice) {
        List<ProductModel> productsWithCategoryAndPrice= productService.findByCategoryAndPriceRange(categoryId,lowPrice, highPrice);
        return new ResponseEntity<>(productsWithCategoryAndPrice, HttpStatus.OK);
    }
    @DeleteMapping("/product")
    public void deleteProductById(@RequestParam Long id)
    {
        productService.deleteById(id);
    }
}
