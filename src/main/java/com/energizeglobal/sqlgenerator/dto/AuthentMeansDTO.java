package com.energizeglobal.sqlgenerator.dto;

import com.energizeglobal.sqlgenerator.enums.UpdateState;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class AuthentMeansDTO {

    private Long id;

    private String name;

    private String description;

    private LocalDate creationDate;

    private String createdBy;

    private UpdateState updateState;

    private Date lastUpdateDate;

    private String lastUpdateBy;

    private List<ProfileDTO> profiles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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


    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public UpdateState getUpdateState() {
        return updateState;
    }

    public void setUpdateState(UpdateState updateState) {
        this.updateState = updateState;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public String getLastUpdateBy() {
        return lastUpdateBy;
    }

    public void setLastUpdateBy(String lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy;
    }

    public List<ProfileDTO> getProfiles() {
        return profiles;
    }

    public void setProfiles(List<ProfileDTO> profiles) {
        this.profiles = profiles;
    }
}
