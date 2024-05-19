package com.spring.beefit.rest;

import com.spring.beefit.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/brand")
public class BrandRest {

    @Autowired
    private BrandService brandService;

    @GetMapping()
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(brandService.getAllBrands());
    }


}
