package com.energizeglobal.sqlgenerator.dto;


import java.sql.Timestamp;
import java.time.Instant;

public class ProfileDTO {
    private long id;
    private String createdBy;
    private Timestamp creationDate;
    private String description;
    private String lastUpdateBy;
    private Instant lastUpdateDate;
    private String name;
    private String updateState;
    private long maxAttempts;
    private String dataEntryFormat;
    private String dataEntryAllowedPattern;

    private AuthentMeansDTO authentMeansDTO;
    private SubIssuerDTO subIssuerDTO;

    public ProfileDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
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

    public long getMaxAttempts() {
        return maxAttempts;
    }

    public void setMaxAttempts(long maxAttempts) {
        this.maxAttempts = maxAttempts;
    }

    public String getDataEntryFormat() {
        return dataEntryFormat;
    }

    public void setDataEntryFormat(String dataEntryFormat) {
        this.dataEntryFormat = dataEntryFormat;
    }

    public String getDataEntryAllowedPattern() {
        return dataEntryAllowedPattern;
    }

    public void setDataEntryAllowedPattern(String dataEntryAllowedPattern) {
        this.dataEntryAllowedPattern = dataEntryAllowedPattern;
    }

    public AuthentMeansDTO getAuthentMeansDTO() {
        return authentMeansDTO;
    }

    public void setAuthentMeansDTO(AuthentMeansDTO authentMeansDTO) {
        this.authentMeansDTO = authentMeansDTO;
    }

    public SubIssuerDTO getSubIssuerDTO() {
        return subIssuerDTO;
    }

    public void setSubIssuerDTO(SubIssuerDTO subIssuerDTO) {
        this.subIssuerDTO = subIssuerDTO;
    }
}
