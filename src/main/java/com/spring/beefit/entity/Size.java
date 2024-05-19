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
public class Size extends AttributeProductEntity implements Serializable {

    @JsonIgnore
    @OneToMany(mappedBy = "size")
    private Set<ProductdetailColorSize> productdetailColorSizes = new HashSet<ProductdetailColorSize>();

}