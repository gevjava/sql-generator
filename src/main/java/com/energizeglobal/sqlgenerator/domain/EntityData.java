package com.energizeglobal.sqlgenerator.domain;

import com.energizeglobal.sqlgenerator.enams.UpdateState;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
@Data
@Embeddable
public class EntityData {

    @Column
    private String name;

    @Column
    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "creationDate", nullable = false)
    private Date creationDate;

    @Column( nullable = false)
    private String createdBy;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UpdateState updateState;

    @Temporal(TemporalType.TIMESTAMP)
    @Column
    private Date lastUpdateDate;

    @Column
    private String lastUpdateBy;

}
