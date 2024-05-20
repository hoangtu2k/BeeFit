package com.spring.beefit.rest;

import com.spring.beefit.service.HandTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/handtype")
public class HandTypeRest {

    @Autowired
    private HandTypeService handTypeService;

    @GetMapping()
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(handTypeService.getAllHandTypes());
    }

}