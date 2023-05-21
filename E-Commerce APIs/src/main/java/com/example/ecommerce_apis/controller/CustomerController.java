package com.example.ecommerce_apis.controller;

import com.example.ecommerce_apis.model.CustomerModel;
import com.example.ecommerce_apis.model.ShipmentModel;
import com.example.ecommerce_apis.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping()
    public CustomerModel addCustomer(@RequestBody CustomerModel customerModel)
    {
        return customerService.addCustomer(customerModel);
    }

}
