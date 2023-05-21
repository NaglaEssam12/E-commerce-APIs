package com.example.ecommerce_apis.service;

import com.example.ecommerce_apis.model.CustomerModel;
import com.example.ecommerce_apis.model.ShipmentModel;
import com.example.ecommerce_apis.repository.CustomerRepository;
import org.springframework.stereotype.Service;


public interface CustomerService {

    CustomerModel addCustomer(CustomerModel customerModel);

}
