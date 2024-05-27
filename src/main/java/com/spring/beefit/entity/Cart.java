package com.spring.beefit.entity;

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
public class Cart implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @OneToOne
    @JoinColumn(name = "IdCustomer")
    private Customer customer;

    @OneToMany(mappedBy = "cart")
    private Set<CartDetail> cartDetails = new HashSet<CartDetail>();

}
