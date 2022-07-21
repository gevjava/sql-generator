package com.energizeglobal.sqlgenerator.dto;

import java.time.Instant;
import java.util.Date;

public class ProfileDTO {
        private String id;
        private String name;
        private String subIssuerCode;
        private String subIssuerLabel;
        private String issuerCode;
        private String issuerLabel;
        private Instant creationDate;
        private String authentMeans;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubIssuerCode() {
        return subIssuerCode;
    }

    public void setSubIssuerCode(String subIssuerCode) {
        this.subIssuerCode = subIssuerCode;
    }

    public String getSubIssuerLabel() {
        return subIssuerLabel;
    }

    public void setSubIssuerLabel(String subIssuerLabel) {
        this.subIssuerLabel = subIssuerLabel;
    }

    public String getIssuerCode() {
        return issuerCode;
    }

    public void setIssuerCode(String issuerCode) {
        this.issuerCode = issuerCode;
    }

    public String getIssuerLabel() {
        return issuerLabel;
    }

    public void setIssuerLabel(String issuerLabel) {
        this.issuerLabel = issuerLabel;
    }

    public Instant getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Instant creationDate) {
        this.creationDate = creationDate;
    }

    public String getAuthentMeans() {
        return authentMeans;
    }

    public void setAuthentMeans(String authentMeans) {
        this.authentMeans = authentMeans;
    }
}
