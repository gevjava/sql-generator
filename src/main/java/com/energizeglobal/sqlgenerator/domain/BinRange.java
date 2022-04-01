package com.energizeglobal.sqlgenerator.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class BinRange {
  @Id
  @Column
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
}
