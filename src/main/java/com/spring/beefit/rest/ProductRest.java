package com.spring.beefit.rest;

import com.spring.beefit.service.ProductDetailService;
import com.spring.beefit.viewmodel.request.ProductReq;
import com.spring.beefit.viewmodel.request.ValidateForm;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductRest {

    @Autowired
    private ProductDetailService service;

    @GetMapping("/findall")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/getall")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/getall1")
    public ResponseEntity<?> getAll1(){
        return ResponseEntity.ok(service.getAll1());
    }

    @PostMapping( value = "/importExel", consumes = "multipart/form-data")
    public ResponseEntity<String> importExel(@RequestParam("file") MultipartFile file) throws IOException {
        try{
            service.importExel(file);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("ok");
        }
        catch(IOException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error");
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Integer id){
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    public ResponseEntity<?> add(@Valid @RequestBody ProductReq productReq, BindingResult result){
        if (result.hasErrors()){
            List<ObjectError> list = result.getAllErrors();
            return ResponseEntity.badRequest().body(list);
        }
        return ResponseEntity.ok(service.addProduct(productReq));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id,@RequestBody ProductReq request){
        return ResponseEntity.ok(service.updateProduct(id,request));
    }

    @PostMapping("/validateupdate")
    public ResponseEntity<?> valid(@Valid @RequestBody ValidateForm validateForm, BindingResult result){
        if (result.hasErrors()){
            List<ObjectError> list = result.getAllErrors();
            return ResponseEntity.badRequest().body(list);
        }
        return ResponseEntity.ok(validateForm);
    }

    @PostMapping("/validate")
    public ResponseEntity<?> validate(@Valid @RequestBody ValidateForm validateForm, BindingResult result){
        if (result.hasErrors()){
            List<ObjectError> list = result.getAllErrors();
            return ResponseEntity.badRequest().body(list);
        }
        if (service.getByCode(validateForm.getCode()) != null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(validateForm);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id){
        return ResponseEntity.ok(service.delete(id));
    }

    @PutMapping("/khoiphuc/{id}")
    public ResponseEntity<?> khoiphucDelete(@PathVariable("id") Integer id){
        return ResponseEntity.ok(service.khoiphucDelete(id));
    }


    @GetMapping("/filter")
    public ResponseEntity<?> getAllByFilter(
            @RequestParam(name = "idcategory",required = false) Integer IdCategory,
            @RequestParam(name = "idmaterial",required = false) Integer IdMaterial,
            @RequestParam(name = "idcolor",required = false) Integer IdColor,
            @RequestParam(name = "idsize",required = false) Integer IdSize,
            @RequestParam(name = "idbrand",required = false) Integer IdBrand,
            @RequestParam(name = "idhandtype",required = false) Integer IdHandType,
            @RequestParam(name = "idnecktype",required = false) Integer IdNeckType,
            @RequestParam(name = "iddesign",required = false) Integer IdDesign,
            @RequestParam("min") Double min,
            @RequestParam("max") Double max,
            @RequestParam(name = "soLuong",required = false) Integer soLuong,
            @RequestParam(name = "soLuong1",required = false) Integer soLuong1){
        return ResponseEntity.ok(service.getAllbyFilter(IdColor,IdSize,IdMaterial,IdCategory,IdBrand,IdHandType,IdNeckType,IdDesign,min,max,soLuong,soLuong1));
    }

}
