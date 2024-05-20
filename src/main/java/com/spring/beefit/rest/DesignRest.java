package com.spring.beefit.rest;

import com.spring.beefit.service.DesignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/design")
public class DesignRest {

    @Autowired
    private DesignService designService;

    @GetMapping()
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(designService.getAllDesigns());
    }

}
