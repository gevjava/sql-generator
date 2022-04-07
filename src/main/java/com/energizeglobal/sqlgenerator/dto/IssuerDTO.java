package com.energizeglobal.sqlgenerator.dto;

import com.energizeglobal.sqlgenerator.domain.EntityData;
import com.energizeglobal.sqlgenerator.domain.MerchantPivotListEntity;
import com.energizeglobal.sqlgenerator.domain.SubIssuerEntity;

import java.util.List;

public class IssuerDTO {

  private Long id;
  private EntityData data;
  private List<SubIssuerEntity> subIssuers;
  private List<MerchantPivotListEntity> merchantPivotList;
  private String code;
  private String label;
  private String authentMeans;
  private String availaibleAuthentMeans;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public EntityData getData() {
    return data;
  }

  public void setData(EntityData data) {
    this.data = data;
  }

  public List<SubIssuerEntity> getSubIssuers() {
    return subIssuers;
  }

  public void setSubIssuers(List<SubIssuerEntity> subIssuers) {
    this.subIssuers = subIssuers;
  }

  public List<MerchantPivotListEntity> getMerchantPivotList() {
    return merchantPivotList;
  }

  public void setMerchantPivotList(List<MerchantPivotListEntity> merchantPivotList) {
    this.merchantPivotList = merchantPivotList;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  public String getAuthentMeans() {
    return authentMeans;
  }

  public void setAuthentMeans(String authentMeans) {
    this.authentMeans = authentMeans;
  }

  public String getAvailaibleAuthentMeans() {
    return availaibleAuthentMeans;
  }

  public void setAvailaibleAuthentMeans(String availaibleAuthentMeans) {
    this.availaibleAuthentMeans = availaibleAuthentMeans;
  }
}
