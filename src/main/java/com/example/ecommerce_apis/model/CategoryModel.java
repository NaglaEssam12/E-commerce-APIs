package com.example.ecommerce_apis.model;

import com.example.ecommerce_apis.entity.Category;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CategoryModel {
    private Long id;
    private String name;
    private boolean active;

    public static CategoryModel toModel(Category category)
    {
        return CategoryModel.builder()
                .id(category.getId())
                .name(category.getName())
                .active(category.isActive())
                .build();
    }
//    @OneToMany( fetch = FetchType.EAGER, mappedBy = "category", cascade = CascadeType.ALL)
//    private List<Product> productList = new ArrayList<>();


}
