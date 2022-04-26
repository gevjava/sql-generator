package com.energizeglobal.sqlgenerator.domain;


import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.CreatedDate;


@Entity
@Table(name = "Rule")
public class RuleEntity {

    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String createdBy;


    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "creationDate", nullable = false)
    private Date creationDate;

    @Column
    private String description;

    @Column
    private String lastUpdateBy;

    @CreatedDate
    @Column(name = "lastUpdateDate", updatable = false)
    private Instant lastUpdateDate = Instant.now();


    @Column
    private String name;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private EntityData.UpdateState updateState;



    @Column(nullable = false)
    private Integer orderRule;

    @ManyToOne
    @JoinColumn(name = "fk_id_profile", referencedColumnName = "id", nullable = false)
    private Profile profile;

    @ManyToMany
    @JoinTable(name = "ProfileSet_Rule", joinColumns = @JoinColumn(name = "id_rule", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "id_profileSet", referencedColumnName = "id"))
    @JsonIgnore
    private List<ProfileSet> profileSets;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rule")
    private List<ConditionEntity> conditions;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public List<ProfileSet> getProfileSets() {
        return profileSets != null ? Collections.unmodifiableList(profileSets) : null;
    }

    public void setProfileSets(List<ProfileSet> profileSets) {
        if(profileSets != null) {
            this.profileSets = new ArrayList<>(profileSets);
        }else{
            this.profileSets = null;
        }
    }

    public List<ConditionEntity> getConditions() {
        return conditions != null ? Collections.unmodifiableList(conditions) : null;
    }

    public void setConditions(List<ConditionEntity> conditions) {
        if(conditions != null) {
            this.conditions = new ArrayList<>(conditions);
        }else{
            this.conditions = null;
        }
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Integer getOrderRule() {
        return orderRule;
    }

    public void setOrderRule(Integer orderRule) {
        this.orderRule = orderRule;
    }

}

