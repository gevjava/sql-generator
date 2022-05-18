package com.energizeglobal.sqlgenerator.dto;

import com.energizeglobal.sqlgenerator.domain.EntityData;
import com.energizeglobal.sqlgenerator.domain.RuleEntity;

import java.time.Instant;

public class RuleConditionDTO {
    private Long id;
    private String name;
    private String createdBy;
    private String lastUpdateBy;
    private String description;
    private Instant creationDate;
    private Instant lastUpdateDate;
    private EntityData.UpdateState updateState;
    private RuleEntity rule;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getCreatedBy() { return createdBy; }

    public void setCreatedBy(String createdBy) { this.createdBy = createdBy; }

    public String getLastUpdateBy() { return lastUpdateBy; }

    public void setLastUpdateBy(String lastUpdateBy) { this.lastUpdateBy = lastUpdateBy; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public Instant getCreationDate() { return creationDate; }

    public void setCreationDate(Instant creationDate) { this.creationDate = creationDate; }

    public Instant getLastUpdateDate() { return lastUpdateDate; }

    public void setLastUpdateDate(Instant lastUpdateDate) { this.lastUpdateDate = lastUpdateDate; }

    public EntityData.UpdateState getUpdateState() { return updateState; }

    public void setUpdateState(EntityData.UpdateState updateState) { this.updateState = updateState; }

    public RuleEntity getRule() { return rule; }

    public void setRule(RuleEntity rule) { this.rule = rule; }
}
