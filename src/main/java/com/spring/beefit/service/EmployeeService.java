package com.spring.beefit.service;

import com.spring.beefit.entity.Employee;
import com.spring.beefit.entity.Role;
import com.spring.beefit.repository.EmployeeRepository;
import com.spring.beefit.repository.RoleRepository;
import com.spring.beefit.viewmodel.request.CapNhatProfile;
import com.spring.beefit.viewmodel.request.ChangeForm;
import com.spring.beefit.viewmodel.request.EmployeeRequest;
import com.spring.beefit.viewmodel.request.ForgetForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Date;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee getByUsername(String username) {
        return employeeRepository.findByUsername(username);
    }

    public Employee getById(Integer Id) {
        Employee employee = employeeRepository.getById(Id);
        return employee;
    }
    private String getNextMa() {
        String biggestMa = employeeRepository.getBiggestMa();
        if (biggestMa == null || biggestMa.isEmpty()) {
            return "NV01";
        } else {
            int currentMa = Integer.parseInt(biggestMa.substring(2));
            String newMa = "NV" + String.format("%02d", ++currentMa);
            return newMa;
        }
    }
    public Employee add(EmployeeRequest request) {
        Employee employee = new Employee();
        employee.setCode(getNextMa());
        employee.setCreateBy(request.getCreateBy());
        employee.setFullname(request.getFullname());
        employee.setUsername(request.getUsername());
        employee.setPassword(request.getPassword());
        employee.setImage(request.getImage());
        employee.setGender(request.getGender());
        employee.setPhone(request.getPhone());
        employee.setEmail(request.getEmail());
        employee.setStatus(0);
        employee.setRole(Role.builder().id(request.getIdRole()).build());
        return employeeRepository.save(employee);
    }
    public Employee update(EmployeeRequest request) {
        Employee employee = new Employee();
        employee.setCode(request.getCode());
        employee.setFullname(request.getFullname());
        employee.setUsername(request.getUsername());
        employee.setPassword(request.getPassword());
        employee.setImage(request.getImage());
        employee.setGender(request.getGender());
        employee.setPhone(request.getPhone());
        employee.setEmail(request.getEmail());
        employee.setStatus(0);
        employee.setRole(Role.builder().id(request.getIdRole()).build());
        return employeeRepository.save(employee);
    }
    // đổi mật khẩu
    public Employee change(Integer idEmployee, ChangeForm form) {
        Employee employee = employeeRepository.getById(idEmployee);
        employee.setPassword(form.getRePasswordMoi());
        employee.setUpdateDate(new Date());
        return employeeRepository.save(employee);
    }

    //cập nhật profile
    public Employee updateprofile(Integer idEmployee, CapNhatProfile form) {
        Employee employee = employeeRepository.getById(idEmployee);
        employee.setFullname(form.getFullname());
        employee.setEmail(form.getEmail());
        employee.setPhone(form.getPhone());
        employee.setGender(form.getGender());
        employee.setImage(form.getImage());
        employee.setUpdateDate(new Date());
        return employeeRepository.save(employee);
    }

    public static String generateRandomString(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            char randomChar = CHARACTERS.charAt(randomIndex);
            sb.append(randomChar);
        }
        return sb.toString();
    }

    public Employee forget(ForgetForm form) {
        Employee employee = employeeRepository.getByUsername(form.getUsername());
        employee.setPassword(generateRandomString(8));
        employee.setUpdateDate(new Date());
        return employeeRepository.save(employee);
    }

    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUV";
    private static final SecureRandom random = new SecureRandom();

    public List<Employee> getAll() {
        return employeeRepository.getAll();
    }

    public List<Employee> getAll1() {
        return employeeRepository.getAll1();
    }

    public List<Employee> getAllbyName(String name) {
        return employeeRepository.searchByName('%' + name + '%');
    }

    public Employee delete(Integer Id) {
        Employee employee = employeeRepository.getById(Id);
        employee.setStatus(1);
        return employeeRepository.save(employee);
    }

    public Employee delete1(Integer Id) {
        Employee employee = employeeRepository.getById(Id);
        employee.setStatus(0);
        return employeeRepository.save(employee);
    }

}

