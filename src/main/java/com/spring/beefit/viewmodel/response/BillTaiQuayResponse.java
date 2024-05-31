package com.spring.beefit.viewmodel.response;

import java.util.Date;

public interface BillTaiQuayResponse {
    Integer getId();
    String getCode();
    Date getPurchaseDate();
    Integer getStatus();
}
