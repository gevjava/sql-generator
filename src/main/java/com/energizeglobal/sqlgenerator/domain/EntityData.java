package com.energizeglobal.sqlgenerator.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Created by a506090 on 08/08/2016.
 * Entity used to track object modifications
 */
@Embeddable
public class EntityData {

    @Column
    private String name;

    @Column
    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "creationDate", nullable = false, updatable = true)
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

    public enum UpdateState{
        WAITING_VALIDATION,
        PUSHED_TO_CONFIG,
        WAITING_FOR_PUSH
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreationDate() {
        return creationDate != null ? (Date) creationDate.clone() : null;
    }

    public void setCreationDate(Date creationDate) {
        if(creationDate != null) {
            this.creationDate = (Date) creationDate.clone();
        }else{
            this.creationDate = null;
        }
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public UpdateState getUpdateState() {
        return updateState;
    }

    public void setUpdateState(UpdateState updateState) {
        this.updateState = updateState;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the lastUpdateDate
     */
    public Date getLastUpdateDate() {
        return lastUpdateDate != null ? (Date) lastUpdateDate.clone() : null;
    }

    /**
     * @param lastUpdateDate the lastUpdateDate to set
     */
    public void setLastUpdateDate(Date lastUpdateDate) {
        if(lastUpdateDate != null) {
            this.lastUpdateDate = (Date) lastUpdateDate.clone();
        }else{
            this.lastUpdateDate = null;
        }
    }

    /**
     * @return the lastUpdateBy
     */
    public String getLastUpdateBy() {
        return lastUpdateBy;
    }

    /**
     * @param lastUpdateBy the lastUpdateBy to set
     */
    public void setLastUpdateBy(String lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy;
    }

}

