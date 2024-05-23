package com.spring.beefit.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "ProductDetail_Color_Size")
public class ProductdetailColorSize implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Integer id;

    @Column(name = "Quantity")
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "IdProduct")
    @JsonBackReference
    private Product product;

    @ManyToOne
    @JoinColumn(name = "IdColor")
    private Color color;

    @ManyToOne
    @JoinColumn(name = "IdSize")
    private Size size;

}