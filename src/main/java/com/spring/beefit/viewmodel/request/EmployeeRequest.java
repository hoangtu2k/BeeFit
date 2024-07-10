package com.spring.beefit.viewmodel.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeRequest {
    @NotBlank(message = "Không được bỏ trống Code")
    private String Code;
    @NotBlank(message = "Không được bỏ trống Tên")
    private String Fullname;
    @NotBlank(message = "Không được bỏ trống UserName")
    private String Username;
    @NotBlank(message = "Không được bỏ trống PassWord")
    private String Password;
    private String Image;
    private Boolean Gender;
    @NotBlank(message = "Không được bỏ trống Phone")
    private String phone;
    @NotBlank(message = "Không được bỏ trống Email")
    private String email;
    @NotBlank(message = "Không được bỏ trống Role")
    private Integer idRole;
    private String createBy;
}
