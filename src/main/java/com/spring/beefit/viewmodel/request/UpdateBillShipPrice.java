package com.spring.beefit.viewmodel.request;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class UpdateBillShipPrice {
    private String Code;
    private BigDecimal Money;
}
