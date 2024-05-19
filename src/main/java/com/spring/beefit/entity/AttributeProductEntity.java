package com.spring.beefit.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@Getter
@Setter
@MappedSuperclass
public abstract class AttributeProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Integer id;

    @Column(name = "Name")
    private String name;

    @Column(name = "CreateDate")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @Temporal(TemporalType.TIMESTAMP)
    private Date CreateDate;

    @Column(name = "UpdateDate")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @Temporal(TemporalType.TIMESTAMP)
    private Date UpdateDate;

    @Column(name = "CreateBy")
    private String createBy;

    @Column(name = "UpdateBy")
    private String updateBy;

    @Column(name = "Status")
    private Integer status;

}
