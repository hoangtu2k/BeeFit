package com.spring.beefit.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Product extends AttributeProductEntity implements Serializable {

    @Column(name = "Code")
    private String code;

    @OneToMany(mappedBy = "product")
    private Set<ProductImage> productImages = new HashSet<ProductImage>();

    @JsonIgnore
    @OneToMany(mappedBy = "product")
    private Set<ProductDetail> productDetails = new HashSet<ProductDetail>();



}