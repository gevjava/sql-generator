package com.energizeglobal.sqlgenerator.dto;


import com.energizeglobal.sqlgenerator.domain.EntityData;

import java.time.Instant;
import java.util.Date;

public class ImageDTO {

    private Long id;
    private String binaryData;
    private String relativePath;
    private String name;
    private String description;
    private Date creationDate;
    private String createdBy;
    private Instant lastUpdateDate;
    private String lastUpdateBy;
    private EntityData.UpdateState updateState;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ImageDTO() {}

    public String getBinaryData() {
        return binaryData;
    }

    public void setBinaryData(String binaryData) {
        this.binaryData = binaryData;
    }

    public String getRelativePath() {
        return relativePath;
    }

    public void setRelativePath(String relativePath) {
        this.relativePath = relativePath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public EntityData.UpdateState getUpdateState() {
        return updateState;
    }

    public void setUpdateState(EntityData.UpdateState updateState) {
        this.updateState = updateState;
    }

    public Instant getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Instant lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public String getLastUpdateBy() {
        return lastUpdateBy;
    }

    public void setLastUpdateBy(String lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy;
    }
}
