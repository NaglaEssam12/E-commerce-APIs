package com.example.ecommerce_apis.service.impl;

import com.example.ecommerce_apis.entity.Customer;
import com.example.ecommerce_apis.entity.Shipment;
import com.example.ecommerce_apis.model.CustomerModel;
import com.example.ecommerce_apis.model.ShipmentModel;
import com.example.ecommerce_apis.repository.CustomerRepository;
import com.example.ecommerce_apis.repository.ShipmentRepository;
import com.example.ecommerce_apis.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements  CustomerService{
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public CustomerModel addCustomer(CustomerModel customerModel) {
        Customer customer = Customer.toEntity(customerModel);
        customerRepository.save(customer);
        return CustomerModel.toModel(customer);
    }



}
