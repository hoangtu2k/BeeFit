package com.spring.beefit.rest;

import com.spring.beefit.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/material")
public class MaterialRest {

    @Autowired
    private MaterialService materialService;

    @GetMapping()
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(materialService.getAllMaterials());
    }

}
