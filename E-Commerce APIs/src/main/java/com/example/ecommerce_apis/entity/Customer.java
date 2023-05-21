package com.example.ecommerce_apis.entity;

import com.example.ecommerce_apis.model.CustomerModel;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String phoneNo;

    public static Customer toEntity(CustomerModel customerModel){
        return  Customer.builder()
                .id(customerModel.getId())
                .name(customerModel.getName())
                .phoneNo(customerModel.getPhoneNo())
                .build();
    }

}
