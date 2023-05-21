package com.example.ecommerce_apis.entity;

import com.example.ecommerce_apis.model.CategoryModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private boolean active;
//    @OneToMany( fetch = FetchType.EAGER, mappedBy = "category", cascade = CascadeType.ALL)
//    private List<Product> productList = new ArrayList<>();
    public static Category toEntity(CategoryModel categoryModel)
    {
        return  Category.builder()
                .id(categoryModel.getId())
                .name(categoryModel.getName())
                .active(categoryModel.isActive())
                .build();
    }

}
