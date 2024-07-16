package com.spring.beefit.viewmodel.request;

import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.sql.Timestamp;
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
    private Timestamp StartDate;
    @NotNull(message = "Không được bỏ trống ngày kết thúc ")
    private Timestamp EndDate;
    @NotNull(message = "Không được bỏ trống số lượng ")
    private Integer Quantity;
    private Date CreateDate;
    private Date UpdateDate;
    private String CreateBy;
    private String UpdateBy;
}
