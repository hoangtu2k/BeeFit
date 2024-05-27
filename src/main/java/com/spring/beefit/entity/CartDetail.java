package com.spring.beefit.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "CartDetail")
public class CartDetail implements Serializable {

    @Id
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

    @ManyToOne
    @JoinColumn(name = "IdCart")
    @JsonBackReference
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "IdProduct")
    private Product product;

}
