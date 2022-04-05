package com.energizeglobal.sqlgenerator.domain;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "authentmeans")
public class AuthentMeans {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "createdBy", nullable = false)
    private String createdBy;

    @Column(name = "creationDate", nullable = false)
    @CreationTimestamp
    private LocalDate creationDate;

    @Column(name = "description")
    private String description;

    @Column(name = "lastUpdateBy")
    private LocalDate lastUpdateBy;

    @Column(name = "lastUpdateDate")
    private LocalDate lastUpdateDate;

    @Column(name = "name")
    private Enum name;

    @Column(name = "updateState", nullable = false)
    private String updateState;

}
