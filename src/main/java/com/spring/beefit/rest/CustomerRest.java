package com.spring.beefit.rest;

import com.spring.beefit.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/customer")
public class CustomerRest {
    @Autowired
    private CustomerService service;

    @GetMapping("/getall")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(service.getAll());
    }
    @GetMapping("/getall1")
    public ResponseEntity<?> getAll1(){
        return ResponseEntity.ok(service.getAll1());
    }

    @GetMapping("/getByUsername/{username}")
    public ResponseEntity<?> getByUsername(@PathVariable("username") String username){
        return ResponseEntity.ok(service.getByUsername(username));
    }


}
