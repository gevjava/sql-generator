package com.energizeglobal.sqlgenerator.domain;

import com.energizeglobal.sqlgenerator.enams.UpdateState;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "authentmeans")
public class AuthentMeansEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "createdBy", nullable = false)
    private String createdBy;

    @Column(name = "creationDate", nullable = false)
    @CreationTimestamp
    private LocalDateTime creationDate;

    @Column(name = "description")
    private String description;

    @Column(name = "lastUpdateBy")
    private String lastUpdateBy;

    @Column(name = "lastUpdateDate")
    private LocalDate lastUpdateDate;

    @Column(name = "name")
    private String name;

    @Column(name = "updateState", nullable = false)
    @Enumerated(EnumType.STRING)
    private UpdateState updateState;



}
