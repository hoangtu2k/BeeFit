package com.spring.beefit.rest;

import com.spring.beefit.entity.Background;
import com.spring.beefit.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/banner")
public class BannerRest {

    @Autowired
    private BannerService service;

    @GetMapping
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(service.getAll());
    }
    @PostMapping
    public ResponseEntity<?> add(@RequestBody Background background){
        return ResponseEntity.ok(service.add(background));
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id,@RequestBody Background background){
        return ResponseEntity.ok(service.update(id,background));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id){
        service.delete(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> index(@PathVariable("id") Integer id){
        return ResponseEntity.ok(service.get(id));
    }


}

