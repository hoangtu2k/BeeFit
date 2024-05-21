package com.spring.beefit.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Promotion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @Column(name = "Code")
    private String code;

    @Column(name = "Name")
    private String name;

    @Column(name = "DiscountType")
    private Boolean discountType;

    @Column(name = "IsDiscount")
    private Boolean isDiscount;

    @Column(name = "Discount")
    private Integer discount;

    @Column(name = "Cash")
    private BigDecimal cash;

    @Column(name = "StartDate")
    private Timestamp startDate;

    @Column(name = "EndDate")
    private Timestamp endDate;

    @Column(name = "CreateDate")
    private Timestamp createDate;

    @Column(name = "Status")
    private Integer status;

    @JsonIgnore
    @OneToMany(mappedBy = "promotion")
    private Set<ProductPromotion> productPromotions = new HashSet<>();

}