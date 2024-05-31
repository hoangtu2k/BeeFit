package com.spring.beefit.viewmodel.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressRequest {
    private Integer Id;
    private String Fullname;
    private String Phone;
    private String Address;
    private String CityName;
    private String DistrictName;
    private String WardName;
    private Integer CityId;
    private Integer DistrictId;
    private Integer WardId;
    private Integer IdCustomer;
}
