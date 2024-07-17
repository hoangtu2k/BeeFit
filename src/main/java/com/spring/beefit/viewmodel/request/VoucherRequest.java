package com.spring.beefit.viewmodel.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class VoucherRequest {

    @NotBlank(message = "Không được bỏ trống mã")
    @Size(max = 30,message = "Mã có độ dài nhỏ hơn hoặc bằng 30 kí tự")
    private String Code;
    @NotBlank(message = "Không được bỏ trống tên khuyến mãi")
    @Size(max = 30,message = "Tên có độ dài nhỏ hơn hoặc bằng 30 kí tự")
    private String Name;
    private Boolean DiscountType;
    private Integer Discount;
    private BigDecimal Cash;
    @NotNull(message = "Không được bỏ trống ngày bắt đầu ")
    private Date StartDate;
    @NotNull(message = "Không được bỏ trống ngày kết thúc ")
    private Date EndDate;
    @NotNull(message = "Không được bỏ trống số lượng ")
    private Integer Quantity;
    private Date CreateDate;
    private Date UpdateDate;
    private String CreateBy;
    private String UpdateBy;
}
