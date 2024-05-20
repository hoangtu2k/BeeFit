package com.spring.beefit.rest;

import com.spring.beefit.service.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/color")
public class ColorRest {

    @Autowired
    private ColorService colorService;

    @GetMapping()
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(colorService.getAllColors());
    }

}
