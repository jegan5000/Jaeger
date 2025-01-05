package com.devprobelms.controller;
import com.devprobelms.service.*;
import com.devprobelms.entity.Customer;
import com.devprobelms.repository.CustomerRepository;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/*
 *  @author: DevProblems(Sarang Kumar A Tak)
 *  Youtube channel: https://youtube.com/@devproblems
 */
@RestController
@RequestMapping("/customer")
public class MsOneController {

    private final CustomerService CustomerService;

    public MsOneController(CustomerService CustomerService) {
        this.CustomerService = CustomerService;
    }

    @PostMapping("/add")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
        Customer savedCustomer = CustomerService.addCustomer(customer);
        return ResponseEntity.ok(savedCustomer);
    }

    @GetMapping("/get")
    public List<Customer> getAllCustomers() {
        return CustomerService.getAllCustomers();
    }
}

