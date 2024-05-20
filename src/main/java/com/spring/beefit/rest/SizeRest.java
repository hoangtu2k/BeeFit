package com.spring.beefit.rest;

import com.spring.beefit.service.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/size")
public class SizeRest {

    @Autowired
    private SizeService sizeService;

    @GetMapping()
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(sizeService.getAllSizes());
    }

}
