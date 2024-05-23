package com.spring.beefit.viewmodel.request;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.sql.Timestamp;


@Getter
@Setter
public class PromotionReq {
    private String Name;
    private Boolean DiscountType;
    private Integer Discount;
    private BigDecimal Cash;
    private Timestamp StartDate;
    private Timestamp EndDate;
    private String CreateBy;
    private String UpdateBy;
}
