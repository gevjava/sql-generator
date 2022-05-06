package com.energizeglobal.sqlgenerator.dto;

public class RuleDTO {

    private Long id;
    private String name;
    private Integer orderRule;
    private String description;

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

    public Integer getOrderRule() {
        return orderRule;
    }

    public void setOrderRule(Integer orderRule) {
        this.orderRule = orderRule;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
