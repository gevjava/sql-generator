package com.energizeglobal.sqlgenerator.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Image")
public class ImageEntity {

    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "image")
    @JsonBackReference
    private List<CustomImageEntity> customImages;

    @Lob
    @Column(columnDefinition = "longblob")
    private String binaryData;

    private String relativePath;
    @Column
    private String name;

    @Column
    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "creationDate", nullable = false)
    private Date creationDate;

    @Column(nullable = false)
    private String createdBy;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private EntityData.UpdateState updateState;

    @Temporal(TemporalType.TIMESTAMP)
    @Column
    private Date lastUpdateDate;

    @Column
    private String lastUpdateBy;

    public enum UpdateState {
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
        if (creationDate != null) {
            this.creationDate = (Date) creationDate.clone();
        } else {
            this.creationDate = null;
        }
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate != null ? (Date) lastUpdateDate.clone() : null;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        if (lastUpdateDate != null) {
            this.lastUpdateDate = (Date) lastUpdateDate.clone();
        } else {
            this.lastUpdateDate = null;
        }
    }

    public String getLastUpdateBy() {
        return lastUpdateBy;
    }

    public void setLastUpdateBy(String lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getBinaryData() {
        return binaryData;
    }

    public void setBinaryData(String binaryData) {
        this.binaryData = binaryData;
    }

    public List<CustomImageEntity> getCustomImages() {
        return customImages;
    }

    public void setCustomImages(List<CustomImageEntity> customImages) {
        this.customImages = customImages;
    }

    public String getRelativePath() {
        return relativePath;
    }

    public void setRelativePath(String relativePath) {
        this.relativePath = relativePath;
    }
}