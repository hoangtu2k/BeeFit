package com.spring.beefit.rest;

import com.spring.beefit.service.EmployeeService;
import com.spring.beefit.viewmodel.request.CapNhatProfile;
import com.spring.beefit.viewmodel.request.ChangeForm;
import com.spring.beefit.viewmodel.request.EmployeeRequest;
import com.spring.beefit.viewmodel.request.ForgetForm;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeRest {

    @Autowired
    private EmployeeService employeeService;
    @GetMapping()
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(employeeService.getAll());
    }

    @GetMapping("/getall1")
    public ResponseEntity<?> getAll1() {
        return ResponseEntity.ok(employeeService.getAll1());
    }
    @PostMapping()
    public ResponseEntity<?>add(@Valid @RequestBody EmployeeRequest request, BindingResult result){
        if(result.hasErrors()){
            List<ObjectError>list= result.getAllErrors();
            return ResponseEntity.badRequest().body(list);
        }
        return  ResponseEntity.ok(employeeService.add(request));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?>add(@PathVariable("id") Integer id,@Valid @RequestBody EmployeeRequest request, BindingResult result){
        if(result.hasErrors()){
            List<ObjectError>list= result.getAllErrors();
            return ResponseEntity.badRequest().body(list);
        }
        return  ResponseEntity.ok(employeeService.update(id,request));
    }
    @GetMapping("/search/{name}")
    public ResponseEntity<?> getAllByEmployee(@PathVariable("name") String name) {
        return ResponseEntity.ok(employeeService.getAllbyName(name));
    }
    @GetMapping("/getByUsername/{username}")
    public ResponseEntity<?> getByUsername(@PathVariable String username) {
        return ResponseEntity.ok(employeeService.getByUsername(username));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Integer id){
        return ResponseEntity.ok(employeeService.getById(id));
    }

    @PutMapping("/updateprofile/{id}")
    public ResponseEntity<?> updateprofile(@PathVariable("id") Integer id, @Valid @RequestBody CapNhatProfile form, BindingResult result){
        if (result.hasErrors()){
            List<ObjectError> list = result.getAllErrors();
            return ResponseEntity.badRequest().body(list);
        }
        return ResponseEntity.ok(employeeService.updateprofile(id,form));
    }

    @PutMapping("/change/{id}")
    public ResponseEntity<?> employee(@PathVariable("id") Integer id, @Valid @RequestBody ChangeForm form, BindingResult result){
        if (result.hasErrors()){
            List<ObjectError> list = result.getAllErrors();
            return ResponseEntity.badRequest().body(list);
        }
        if (!employeeService.getById(id).getPassword().equals(form.getPasswordCu())){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("err");
        }

        return ResponseEntity.ok(employeeService.change(id,form));
    }

    @PutMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer Id) {
        return ResponseEntity.ok(employeeService.delete(Id));
    }

    @PutMapping("/khoiphuc/{id}")
    public ResponseEntity<?> khoiphuc(@PathVariable("id") Integer Id) {
        return ResponseEntity.ok(employeeService.delete1(Id));
    }


    @PutMapping("/forget")
    public ResponseEntity<?> forget(@Valid @RequestBody ForgetForm form, BindingResult result) {
        if (result.hasErrors()) {
            List<ObjectError> list = result.getAllErrors();
            return ResponseEntity.badRequest().body(list);
        }
        return ResponseEntity.ok(employeeService.forget(form));
    }

}
