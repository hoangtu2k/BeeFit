package com.spring.beefit.viewmodel.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductReq {
    private String code;
    private String name;
    private String createBy;
    private String updateBy;
}
