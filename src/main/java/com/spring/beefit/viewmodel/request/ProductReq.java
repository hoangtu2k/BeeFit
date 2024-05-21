package com.spring.beefit.viewmodel.request;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class ProductReq {
    private String code;
    private String name;
    private BigDecimal Price;
    private Integer discount;
    private String description;
    private String createBy;
    private String updateBy;
    private Integer idBrand;
    private Integer idCategory;
    private Integer idDesign;
    private Integer idHandType;
    private Integer idNeckType;
    private Date discountDate;
}
