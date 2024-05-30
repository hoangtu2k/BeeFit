package com.spring.beefit.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @Column(name = "Code")
    private String code;

    @Column(name = "Fullname")
    private String fullname;

    @Column(name = "Username")
    private String username;

    @Column(name = "Password")
    private String password;

    @Column(name = "Image")
    private String image;

    @Column(name = "Gender")
    private Boolean gender;

    @Column(name = "Phone")
    private String phone;

    @Column(name = "Email")
    private String email;

    @Column(name = "CreateDate")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @Column(name = "UpdateDate")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;

    @Column(name = "CreateBy")
    private String createBy;

    @Column(name = "UpdateBy")
    private String updateBy;

    @Column(name = "Status")
    private Integer status;

    @JsonBackReference
    @OneToMany(mappedBy = "customer")
    private Set<Coupon> coupons = new HashSet<Coupon>();
    @JsonBackReference
    @OneToMany(mappedBy = "customer")
    private Set<Address> addresses = new HashSet<Address>();
    @JsonIgnore
    @OneToMany(mappedBy = "customer")
    private Set<Bill> bills = new HashSet<Bill>();
    @JsonIgnore
    @OneToMany(mappedBy = "customer")
    private Set<Rating> ratings = new HashSet<Rating>();

}
