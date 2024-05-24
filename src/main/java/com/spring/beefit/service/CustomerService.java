package com.spring.beefit.service;

import com.spring.beefit.entity.Customer;
import com.spring.beefit.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAll() {
        return customerRepository.getAll();
    }

    public List<Customer> getAll1() {
        return customerRepository.getAll1();
    }

    public Customer getByUsername(String username) {
        return customerRepository.findByUsername(username);
    }

    public Customer getById(Integer Id){
        Customer customer = customerRepository.getById(Id);
        return customer;
    }


}
