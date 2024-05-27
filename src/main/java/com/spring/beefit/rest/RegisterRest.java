package com.spring.beefit.rest;

import com.spring.beefit.service.CustomerService;
import com.spring.beefit.viewmodel.request.RegisterForm;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/register")
public class RegisterRest {
    @Autowired
    private CustomerService service;

    @PostMapping
    public ResponseEntity<?> add(@Valid @RequestBody RegisterForm form, BindingResult result){
        if (result.hasErrors()){
            List<ObjectError> list = result.getAllErrors();
            return ResponseEntity.badRequest().body(list);
        }
        if(service.getByUsername(form.getUsername()) != null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("errorMessage");
        }
        return ResponseEntity.ok(service.register(form));
    }



}
