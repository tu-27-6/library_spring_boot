package com.example.library_management.services;

import com.example.library_management.models.CustomerModel;
import com.example.library_management.models.LibraryCardModel;
import com.example.library_management.repository.CustomerRepository;
import com.example.library_management.repository.LibraryCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private LibraryCardRepository libraryCardRepository;

    public CustomerModel createCustomer(CustomerModel customer) {
        Optional<LibraryCardModel> libraryCardModelOptional =
                libraryCardRepository.findById(customer.getLibraryCardId());
        if (libraryCardModelOptional.isEmpty()) {
            throw new EntityNotFoundException("Library card Id not found!");
        }
        return customerRepository.save(customer);
    }

    public List<CustomerModel> getAllCustomer() {
        return customerRepository.findAll();
    }

    public void deleteCustomer(String id) {
        Optional<CustomerModel> optionalCustomerModel = customerRepository.findById(id);
        if (optionalCustomerModel.isEmpty()) {
            throw new EntityNotFoundException("Id not found!");
        } else {
            customerRepository.deleteById(id);
        }
    }

    public CustomerModel updateCustomer(CustomerModel customer, String id) {
        Optional<CustomerModel> optional = customerRepository.findById(id);
        if (optional.isEmpty()) {
            throw new EntityNotFoundException("Id not found!");
        } else {
            customer.setId(id);
            if (customer.getName() == null || customer.getName().isEmpty()) {
                customer.setName(optional.get().getName());
            }
            if (customer.getAddress() == null || customer.getAddress().isEmpty()) {
                customer.setAddress(optional.get().getAddress());
            }
            if (customer.getLibraryCardId() == null || customer.getLibraryCardId().isEmpty()) {
                customer.setLibraryCardId(optional.get().getLibraryCardId());
            }
            return customerRepository.save(customer);
        }
    }
}
