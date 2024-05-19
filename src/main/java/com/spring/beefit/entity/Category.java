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
public class Category extends AttributeProductEntity implements Serializable {

    @JsonIgnore
    @OneToMany(mappedBy = "category")
    private Set<ProductDetail> productDetails = new HashSet<ProductDetail>();

}