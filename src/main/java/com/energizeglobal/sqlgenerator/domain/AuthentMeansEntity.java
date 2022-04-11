package com.energizeglobal.sqlgenerator.domain;

import com.energizeglobal.sqlgenerator.enums.UpdateState;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLUpdate;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
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

    @CreatedDate
    @Column(name = "creationDate", updatable = false)
    private LocalDateTime creationDate;

    @Column(name = "description")
    private String description;

    @Column(name = "lastUpdateBy")
    private String lastUpdateBy;

    @CreatedDate
    @Column(name = "lastUpdateDate", updatable = true)
    private LocalDateTime lastUpdateDate;

    @Column(name = "name")
    private String name;

    @Column(name = "updateState", nullable = false)
    @Enumerated(EnumType.STRING)
    private UpdateState updateState;



}
