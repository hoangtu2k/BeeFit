package com.spring.beefit.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BillDetail implements Serializable {

    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @Column(name = "UnitPrice")
    private BigDecimal unitPrice;

    @Column(name = "Quantity")
    private Integer quantity;

    @Column(name = "IdColor")
    private Integer idColor;

    @Column(name = "IdSize")
    private Integer idSize;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "IdOrder")
    private Bill bill;

    @ManyToOne
    @JoinColumn(name = "IdProduct")
    private Product product;


}
