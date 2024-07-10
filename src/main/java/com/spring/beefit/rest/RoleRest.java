package com.spring.beefit.rest;

import com.spring.beefit.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/role")
public class RoleRest {
    @Autowired
    private EmployeeService employeeService;
    @GetMapping()
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(employeeService.getAllRoles());
    }
}
