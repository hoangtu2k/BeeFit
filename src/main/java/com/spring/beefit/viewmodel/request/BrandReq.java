package com.spring.beefit.viewmodel.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
@Component
public class BrandReq {

    @NotBlank(message = "Tên không được bỏ trống !")
    @Size(max = 100,message = "Tên có độ dài nhỏ hơn hoặc bằng 100 kí tự")
    private String name;

}
