package com.spring.beefit.rest;

import com.spring.beefit.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/category")
public class CategoryRest {

    @Autowired
    private CategoryService categoryService;

    @GetMapping()
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(categoryService.getAllCategories());
    }

}