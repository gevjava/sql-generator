package com.energizeglobal.sqlgenerator.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "profile")
public class ProfileSet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToMany(cascade = CascadeType.ALL,mappedBy = "profileSets")
    private List<RuleEntity> rules;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<RuleEntity> getRules() {
        return rules != null ?
                Collections.unmodifiableList(rules) : null;
    }

    public void setRules(List<RuleEntity> rules) {
        if(rules != null) {
            this.rules = new ArrayList<>(rules);
        }else{
            this.rules = null;
        }
    }
}
