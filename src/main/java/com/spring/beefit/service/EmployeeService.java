package com.spring.beefit.service;

import com.spring.beefit.entity.Employee;
import com.spring.beefit.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee getByUsername(String username) {
        return employeeRepository.findByUsername(username);
    }

}
