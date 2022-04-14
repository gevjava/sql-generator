package com.energizeglobal.sqlgenerator.domain;

import javax.persistence.*;

@Entity
@Table(name = "subissuer")
public class SubIssuer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    @ManyToOne
    @JoinColumn(name = "fk_id_issuer", referencedColumnName = "id")
    private IssuerEntity issuer;


    public SubIssuer() {
    }

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public IssuerEntity getIssuer() {
        return issuer;
    }

    public void setIssuer(IssuerEntity issuer) {
        this.issuer = issuer;
    }
}
