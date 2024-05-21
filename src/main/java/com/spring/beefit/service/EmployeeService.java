package com.spring.beefit.service;

import com.spring.beefit.entity.Employee;
import com.spring.beefit.entity.Role;
import com.spring.beefit.repository.EmployeeRepository;
import com.spring.beefit.repository.RoleRepository;
import com.spring.beefit.viewmodel.request.CapNhatProfile;
import com.spring.beefit.viewmodel.request.ChangeForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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

    public Employee getById(Integer Id){
        Employee employee = employeeRepository.getById(Id);
        return employee;
    }

    // đổi mật khẩu
    public Employee change(Integer idEmployee, ChangeForm form){
        Employee employee = employeeRepository.getById(idEmployee);
        employee.setPassword(form.getRePasswordMoi());
        employee.setUpdateDate(new Date());
        return employeeRepository.save(employee);
    }

    //cập nhật profile
    public Employee updateprofile(Integer idEmployee, CapNhatProfile form){
        Employee employee = employeeRepository.getById(idEmployee);
        employee.setFullname(form.getFullname());
        employee.setEmail(form.getEmail());
        employee.setPhone(form.getPhone());
        employee.setGender(form.getGender());
        employee.setImage(form.getImage());
        employee.setUpdateDate(new Date());
        return employeeRepository.save(employee);
    }


}
