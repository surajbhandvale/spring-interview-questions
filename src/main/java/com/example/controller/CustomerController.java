package com.example.controller;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.ApiResponse;
import com.example.service.CustomerService;

@RestController
@RequestMapping("/api/v1/customers")
@Slf4j
public class CustomerController {

    //Logger logger = LoggerFactory.getLogger(CustomerController.class);
    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    /**
     * Find all customers
     * @return ApiResponse object
     */
    @GetMapping("/")
    public ResponseEntity<ApiResponse<Object>> getEmployees(){
        return customerService.findAll();
    }
}