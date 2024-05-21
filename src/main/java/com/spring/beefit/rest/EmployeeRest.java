package com.spring.beefit.rest;

import com.spring.beefit.service.EmployeeService;
import com.spring.beefit.viewmodel.request.CapNhatProfile;
import com.spring.beefit.viewmodel.request.ChangeForm;
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


}
