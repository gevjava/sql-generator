package com.energizeglobal.sqlgenerator.domain;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Data
@Table(name = "Issuer")
public class Issuer {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(name = "code")
  private String code;

  @Column(name = "createdBy")
  private String createdBy;

  @CreatedDate
  @Column(name = "creationDate", updatable = false)
  private Instant creationDate = Instant.now();

  @Column(name = "description")
  private String description;

  @Column(name = "lastUpdateBy")
  private String lastUpdateBy;

  @CreatedDate
  @Column(name = "lastUpdateDate", updatable = false)
  private Instant lastUpdateDate = Instant.now();

  @Column(name = "name")
  private String name;

  @Column(name = "updateState")
  private String updateState;

  @Column(name = "label")
  private String label;

  @Column(name = "availaibleAuthentMeans")
  private String availaibleAuthentMeans;
}
