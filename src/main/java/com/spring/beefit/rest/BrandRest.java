package com.spring.beefit.rest;

import com.spring.beefit.service.BrandService;
import com.spring.beefit.viewmodel.request.BrandReq;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/brand")
public class BrandRest {

    @Autowired
    private BrandService brandService;

    @GetMapping()
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(brandService.getAllBrands());
    }

    @PostMapping()
    public ResponseEntity<?> add(@Valid @RequestBody BrandReq request, BindingResult result){
        if (result.hasErrors()){
            List<ObjectError> list = result.getAllErrors();
            return ResponseEntity.badRequest().body(list);
        }
        return ResponseEntity.ok(brandService.add(request));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id,@Valid @RequestBody BrandReq request, BindingResult result){
        if (result.hasErrors()){
            List<ObjectError> list = result.getAllErrors();
            return ResponseEntity.badRequest().body(list);
        }
        return ResponseEntity.ok(brandService.update(id,request));
    }


}
