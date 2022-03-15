package com.energizeglobal.sqlgenerator.domain;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "subissuer")
public class SubIssuer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    String name;

    @Column(name = "code")
    String code;

    @Column(name = "authentMeans")
    String authentMeans;

    @Column(name = "acsId")
    String acsId;

    @Column(name = "createdBy")
    String createdBy;

    @CreatedDate
    @Column(name = "creationDate", updatable = false)
    private Instant creationDate = Instant.now();

    @Column
    String description;

    @Column(name = "lastUpdateBy")
    String lastUpdateBy;

    @CreatedDate
    @Column(name = "lastUpdateDate", updatable = false)
    private Instant lastUpdateDate = Instant.now();


    @Column(name = "updateState")
    String updateState;

    @Column(name = "label")
    String label;

    @Column(name = "availaibleAuthentMeans")
    String availaibleAuthentMeans;

    @Column(name = "manageBackupsCombinedAmounts")
    boolean manageBackupsCombinedAmounts;

    public String getAuthentMeans() {
        return authentMeans;
    }

    public void setAuthentMeans(String authentMeans) {
        this.authentMeans = authentMeans;
    }

    public String getAcsId() {
        return acsId;
    }

    public void setAcsId(String acsId) {
        this.acsId = acsId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Instant getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Instant creationDate) {
        this.creationDate = creationDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLastUpdateBy() {
        return lastUpdateBy;
    }

    public void setLastUpdateBy(String lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy;
    }

    public Instant getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Instant lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUpdateState() {
        return updateState;
    }

    public void setUpdateState(String updateState) {
        this.updateState = updateState;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getAvailaibleAuthentMeans() {
        return availaibleAuthentMeans;
    }

    public void setAvailaibleAuthentMeans(String availaibleAuthentMeans) {
        this.availaibleAuthentMeans = availaibleAuthentMeans;
    }
}

