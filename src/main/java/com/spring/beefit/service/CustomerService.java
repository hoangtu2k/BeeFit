package com.spring.beefit.service;

import com.spring.beefit.entity.Customer;
import com.spring.beefit.repository.CustomerRepository;
import com.spring.beefit.viewmodel.request.RegisterForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
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

    public String genCode(){
        // Tạo đối tượng Random
        long timestamp = Instant.now().getEpochSecond();
        String code = "KH" + timestamp;
        return code;
    }
    // đăng ký
    public Customer register(RegisterForm form){
        Customer customer = new Customer();
        customer.setCode(genCode());
        customer.setEmail(form.getEmail());
        customer.setFullname(form.getFullname());
        customer.setUsername(form.getUsername());
        customer.setPassword(form.getPassword());
        customer.setCreateDate(new Date());
        customer.setStatus(0);
        return customerRepository.save(customer);
    }


}
