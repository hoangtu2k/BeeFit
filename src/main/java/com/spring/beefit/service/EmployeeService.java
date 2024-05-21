package com.spring.beefit.service;

import com.spring.beefit.entity.Employee;
import com.spring.beefit.entity.Role;
import com.spring.beefit.repository.EmployeeRepository;
import com.spring.beefit.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Role> getAllRoles() {
        return roleRepository.getAll();
    }

    public Employee getByUsername(String username) {
        return employeeRepository.findByUsername(username);
    }

}
