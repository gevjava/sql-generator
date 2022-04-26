package com.energizeglobal.sqlgenerator.domain;


import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "RuleCondition")
public class ConditionEntity {

    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private EntityData data;

    @ManyToOne
    @JoinColumn(name = "fk_id_rule", referencedColumnName = "id")
    @JsonIgnore
    private RuleEntity rule;

    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public EntityData getData() {
        return data;
    }


    public void setData(EntityData data) {
        this.data = data;
    }

    public RuleEntity getRule() {
        return rule;
    }


    public void setRule(RuleEntity rule) {
        this.rule = rule;
    }


}