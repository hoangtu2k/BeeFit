package com.spring.beefit.viewmodel.request;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class ProductDetailReq {
    private BigDecimal Price;
    private Integer Discount;
    private String Description;
    private String CreateBy;
    private String UpdateBy;
    private Integer IdProduct;
    private Integer IdBrand;
    private Integer IdCategory;
    private Integer IdDesign;
    private Integer IdHandType;
    private Integer IdNeckType;
    private Date DiscountDate;
}
