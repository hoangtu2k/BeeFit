package com.spring.beefit.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Bill implements Serializable {

    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @Column(name = "Code")
    private String code;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "PurchaseDate")
    private Date purchaseDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "EstimatedDate")
    private Date estimatedDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "PaymentDate")
    private Date paymentDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DelyveryDate")
    private Date delyveryDate;

    @Column(name = "TotalPrice")
    private BigDecimal totalPrice;

    @Column(name = "ShipPrice")
    private BigDecimal shipPrice;

    @Column(name = "TotalPriceLast")
    private BigDecimal totalPriceLast;

    @Column(name = "Note")
    private String note;
    @Column(name = "PayType")
    private Integer payType;

    @Column(name = "PayStatus")
    private Integer payStatus;

    @Column(name = "CodeGHN")
    private String codeGHN;

    @Column(name = "IdCoupon")
    private Integer idCoupon;

    @Column(name = "Status")
    private Integer status;

    @Column(name = "TypeStatus")
    private Integer typeStatus;

    @ManyToOne
    @JoinColumn(name = "IdAddress")
    private Address address;

    @ManyToOne
    @JoinColumn(name = "IdCustomer")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "IdEmployee")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "IdVoucher")
    private Voucher voucher;

    @JsonIgnore
    @OneToMany(mappedBy = "bill")
    private Set<BillHistory> billHistories = new HashSet<BillHistory>();


}
