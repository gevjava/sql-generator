package com.energizeglobal.sqlgenerator.repository;

import com.energizeglobal.sqlgenerator.domain.SubIssuerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubIssuerRepository extends JpaRepository<SubIssuerEntity, Long> {

    SubIssuerEntity findByCode(String code);

    void deleteByCode(String code);

}
