package com.spring.beefit.viewmodel.request;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Getter
@Setter
public class ValidatePromotion {

    private String Code;

    @NotBlank(message = "Tên khuyến mãi không được bỏ trống")
    @Size(max = 30,message = "Tên có độ dài nhỏ hơn hoặc bằng 30 kí tự")
    private String Name;

    @NotNull(message = "Ngày hết hạn không được bỏ trống")
    @Future(message = "Ngày hết hạn phải là một ngày trong tương lai")
    private Timestamp EndDate;

}
