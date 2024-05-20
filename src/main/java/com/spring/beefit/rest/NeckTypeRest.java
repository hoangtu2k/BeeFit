package com.spring.beefit.rest;

import com.spring.beefit.service.NeckTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/necktype")
public class NeckTypeRest {

    @Autowired
    private NeckTypeService neckTypeService;

    @GetMapping()
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(neckTypeService.getAllNeckTypes());
    }

}