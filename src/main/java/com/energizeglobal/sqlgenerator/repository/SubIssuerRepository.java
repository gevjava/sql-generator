package com.energizeglobal.sqlgenerator.repository;

import com.energizeglobal.sqlgenerator.domain.SubIssuer;
import com.energizeglobal.sqlgenerator.dto.SubIssuerDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubIssuerRepository extends JpaRepository<SubIssuerDto,Long> {

}
