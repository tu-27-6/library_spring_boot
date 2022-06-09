package com.example.library_management.controllers;

import com.example.library_management.models.CustomerModel;
import com.example.library_management.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/library/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/get_all_customers")
    public ResponseEntity<?> getAllCustomers() {
        try {
            List<CustomerModel> data = customerService.getAllCustomer();
            return new ResponseEntity<>(data, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/create_customer")
    public ResponseEntity<?> createCustomers(@RequestParam CustomerModel customer) {
        try {
            CustomerModel data = customerService.createCustomer(customer);
            return new ResponseEntity<>(data, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update_customer")
    public ResponseEntity<?> updateCustomer(@RequestBody CustomerModel customer, @RequestParam String id) {
        try {
            CustomerModel data = customerService.updateCustomer(customer, id);
            return new ResponseEntity<>(data, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete_customer")
    public ResponseEntity<?> deleteCustomer(@RequestParam String id) {
        try {
            customerService.deleteCustomer(id);
            return new ResponseEntity<>("Delete success", HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
    }
}
