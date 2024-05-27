package com.spring.beefit.viewmodel.request;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class ProductReq {

    private String Code;
    private String Name;
    private BigDecimal Price;
    private Double Weight;
    private String Description;
    private String CreateBy;
    private String UpdateBy;
    private Integer IdProduct;
    private Integer IdBrand;
    private Integer IdCategory;
    private Integer IdDesign;
    private Integer IdHandType;
    private Integer IdNeckType;
    private String Url;
    private Boolean MainImage;
    private Integer IdSize;
    private Integer IdColor;
    private Integer Quantity;
    private Integer IdMaterial;
    private Integer Discount;
    private Date DiscountDate;

}
