package com.energizeglobal.sqlgenerator.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "MerchantPivotList")
public class MerchantPivotListEntity {

    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String createdBy;

    @Temporal(TemporalType.TIMESTAMP)
    @Column
    private Date creationDate;

    @Column
    private String lastUpdateBy;

    @Temporal(TemporalType.TIMESTAMP)
    @Column
    private Date lastUpdateDate;

    @Column(nullable = false)
    private String level;

    @Column(nullable = false)
    private String keyword;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private Long amount;

    @Column(nullable = false, columnDefinition = "BIT", length = 1)
    private boolean display;

    @Column(nullable = false, columnDefinition = "BIT", length = 1)
    private boolean expertMode;

    @Column(nullable = false, columnDefinition = "BIT", length = 1)
    private boolean forceAuthent;

}
