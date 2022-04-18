package com.energizeglobal.sqlgenerator.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "cryptoconfig")
public class CryptoConfigurationEntity implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "protocolOne")
    private String protocolOne;

    @Column(name = "protocolTwo")
    private String protocolTwo;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "cryptoConfigurationEntity")
    @JsonIgnore
    private List<SubIssuerEntity> linkedSubIssuers = new ArrayList<>();


    @OneToMany(mappedBy = "cryptoConfigurationEntity")
    @JsonIgnore
    private List<BinRangeEntity> linkedBinRanges = new ArrayList<>();

}
