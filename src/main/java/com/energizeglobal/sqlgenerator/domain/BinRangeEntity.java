package com.energizeglobal.sqlgenerator.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "binrange")
public class BinRangeEntity {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    @JoinTable(name = "BinRange_SubIssuer", joinColumns = @JoinColumn(name = "id_binRange", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "id_subIssuer", referencedColumnName = "id"))
    private List<SubIssuerEntity> subIssuers;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_id_cryptoConfig", referencedColumnName = "id")
    @JsonIgnore
    private CryptoConfigurationEntity cryptoConfigurationEntity;
}
