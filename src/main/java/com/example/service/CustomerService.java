package com.example.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.dto.ApiResponse;
import com.example.dto.ResponseBuilderObj;
import com.example.entity.Customer;
import com.example.repository.CustomerRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CustomerService {

    private CustomerRepository customerRepository;
    private ResponseBuilderObj responseBuilderObj;

    public CustomerService(CustomerRepository customerRepository, ResponseBuilderObj responseBuilderObj){
        this.customerRepository = customerRepository;
        this.responseBuilderObj = responseBuilderObj;
    }

    public ResponseEntity<ApiResponse<Object>> findAll() {
        List<Customer> customers = customerRepository.findAll();
        return responseBuilderObj.buildResponse(HttpStatus.OK.value(),"Customer details",customers);
    }
}