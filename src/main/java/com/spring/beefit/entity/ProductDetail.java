package com.spring.beefit.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class ProductDetail implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Integer id;

    @Column(name = "Price")
    private BigDecimal price;

    @Column(name = "Discount")
    private Integer discount;

    @Column(name = "DiscountDate")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @Temporal(TemporalType.TIMESTAMP)
    private Date discountDate;

    @Column(name = "Description")
    private String description;

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

    @ColumnDefault("0")
    @Column(name = "Status")
    private Integer status;

    @ManyToOne
    @JoinColumn(name = "IdProduct")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "IdBrand")
    private Brand brand;

    @ManyToOne
    @JoinColumn(name = "IdCategory")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "IdDesign")
    private Design design;

    @ManyToOne
    @JoinColumn(name = "IdHandType")
    private HandType handType;

    @ManyToOne
    @JoinColumn(name = "IdNeckType")
    private NeckType neckType;

    @OneToMany(mappedBy = "productDetail")
    private Set<ProductdetailMaterial> productDetail_materials = new HashSet<ProductdetailMaterial>();

    @OneToMany(mappedBy = "productDetail")
    private Set<ProductdetailColorSize> productDetail_size_colors = new HashSet<ProductdetailColorSize>();


}