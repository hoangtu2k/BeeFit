package com.spring.beefit.rest;

import com.spring.beefit.service.ProductDetailColorSizeService;
import com.spring.beefit.viewmodel.request.ProductReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/productdetail_color_size")
public class ProductDetail_Color_SizeRest {

    @Autowired
    private ProductDetailColorSizeService service;

    @GetMapping("/getbycolor")
    public ResponseEntity<?> getByColor(@RequestParam("IdProduct") Integer IdProduct , @RequestParam("IdColor") Integer IdColor){
        return ResponseEntity.ok(service.getByColor(IdProduct,IdColor));
    }
    @GetMapping("/getall")
    public ResponseEntity<?> getall(){
        return ResponseEntity.ok(service.getAll());
    }
    @GetMapping("/getbyid/{id}")
    public ResponseEntity<?> getbyid(@PathVariable("id") Integer id){
        return ResponseEntity.ok(service.getByIdd(id));
    }
    @GetMapping("/getbyproduct/{id}")
    public ResponseEntity<?> getbyproduct(@PathVariable("id") Integer id){
        return ResponseEntity.ok(service.getByProduct(id));
    }
    @GetMapping("/getallbykeyword")
    public ResponseEntity<?> getbyid(@RequestParam(value = "keyword",required = false) String keyword,@RequestParam(value = "idColor",required = false) Integer idCololor,@RequestParam(value = "idSize",required = false) Integer idSize){
        return ResponseEntity.ok(service.getAllByNameAndCodeProduct(keyword,idCololor,idSize));
    }
    @GetMapping("/getQuantityProduct")
    public ResponseEntity<?> getQuantityProduct(@RequestParam("IdProduct") Integer IdProduct){
        return ResponseEntity.ok(service.getQuantityByProduct(IdProduct));
    }
    @GetMapping("/getQuantityProductAndColor")
    public ResponseEntity<?> getQuantityProductAndColor(@RequestParam("IdProduct") Integer IdProduct,@RequestParam("IdColor") Integer IdColor){
        return ResponseEntity.ok(service.getQuantityByProductAndColor(IdProduct,IdColor));
    }
    @GetMapping("/getQuantityProductAndColorAndSize")
    public ResponseEntity<?> getQuantityProductAndColorAndSize(@RequestParam("IdProduct") Integer IdProduct,@RequestParam("IdColor") Integer IdColor,@RequestParam("IdSize") Integer IdSize){
        return ResponseEntity.ok(service.getQuantityByProductAndColorAndSize(IdProduct,IdColor,IdSize));
    }

    @PostMapping()
    public ResponseEntity<?> add(@RequestBody ProductReq request){
        return ResponseEntity.ok(service.add(request));
    }
    @PutMapping("/updateQuantity")
    public ResponseEntity<?> updateQuantity(@RequestParam("IdProduct") Integer IdProduct, @RequestParam("IdColor") Integer IdColor, @RequestParam("IdSize") Integer IdSize, @RequestParam("Quantity") Integer Quanity){
        return ResponseEntity.ok(service.updateQuantity(IdProduct,IdColor,IdSize,Quanity));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id){
        service.delete(id);
        return ResponseEntity.ok("ok");
    }



}
