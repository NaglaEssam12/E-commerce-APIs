package com.example.ecommerce_apis.model;

import com.example.ecommerce_apis.entity.Customer;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerModel {

    private Long id;
    private String name;
    private String phoneNo;

    public static CustomerModel toModel(Customer customer)
    {
        return  CustomerModel.builder()
                .id(customer.getId())
                .name(customer.getName())
                .phoneNo(customer.getPhoneNo())
                .build();
    }

}
