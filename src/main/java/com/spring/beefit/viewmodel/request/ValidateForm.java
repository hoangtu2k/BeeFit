package com.spring.beefit.viewmodel.request;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ValidateForm {

    private String Code;
    
    @NotBlank(message = "Tên không được bỏ trống !")
    @Size(max = 100,message = "Tên có độ dài nhỏ hơn hoặc bằng 100 kí tự")
    @Size(min = 10,message = "Tên lớn hơn 10 kí tự")
    private String Name;
    
    @NotBlank(message = "Giá bán không được bỏ trống !")
    @Pattern(regexp = "^(?!0)([1-9]\\d{0,7}(?:\\.\\d{1,2})?|99999999(?:\\.0{1,2})?)$",message = "Giá bán phải là số lớn hơn 0 và nhỏ hơn 99,999,999 !")
    private String Price;
   
    @NotBlank(message = "Giảm giá không được bỏ trống !")
    @Pattern(regexp = "^[0-9]\\d*$",message = "Giảm giá phải là số nguyên dương !")
    @Pattern(regexp = "^(?:100|[0-9]|[1-9]\\d)$",message = "Giảm giá trong khoảng từ 0 đến 100 !")
    private String Discount;
  
    @Size(max = 255,message = "Mô tả có độ dài nhỏ hơn hoặc bằng 255 kí tự")
    private String Description;

}
