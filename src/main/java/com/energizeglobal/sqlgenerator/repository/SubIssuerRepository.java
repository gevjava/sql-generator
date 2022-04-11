package com.energizeglobal.sqlgenerator.repository;

import com.energizeglobal.sqlgenerator.domain.SubIssuer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface SubIssuerRepository extends JpaRepository<SubIssuer, Long> {

    @Transactional
    SubIssuer findByCode(String code);

    @Transactional
    void deleteByCode(String code);

}
