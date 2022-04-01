package com.energizeglobal.sqlgenerator.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "cryptoconfig")
public class CryptoConfig implements Serializable {

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

  //  @OneToMany(mappedBy = "cryptoConfigurationEntity")
  //  @JsonIgnore
  //  private List<SubIssuer> linkedSubIssuers = new ArrayList<>();
  //
  //  @OneToMany(mappedBy = "cryptoConfigurationEntity")
  //  @JsonIgnore
  //  private List<BinRange> linkedBinRanges = new ArrayList<>();
}
