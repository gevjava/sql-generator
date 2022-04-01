package com.energizeglobal.sqlgenerator.domain;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class SubIssuer {

  @Id
  @Column
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
}
