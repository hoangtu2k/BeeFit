package com.spring.beefit.viewmodel.request;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.sql.Timestamp;


@Getter
@Setter
public class PromotionRequest {

    @NotBlank(message = "Không được bỏ trống mã")
    @Size(max = 30,message = "Mã có độ dài nhỏ hơn hoặc bằng 30 kí tự")
    private String code;
    @NotBlank(message = "Không được bỏ trống tên khuyến mãi")
    @Size(max = 30,message = "Tên có độ dài nhỏ hơn hoặc bằng 30 kí tự")
    private String name;
    private Boolean discountType;
    private Boolean isDiscount;
    private Integer discount;
    private BigDecimal cash;
    @NotNull(message = "Không được bỏ trống ngày bắt đầu ")
    private Timestamp startDate;
    @NotNull(message = "Không được bỏ trống ngày kết thúc ")
    private Timestamp endDate;
    @NotBlank
    private String createBy;

}
