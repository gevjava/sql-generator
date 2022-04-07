package com.energizeglobal.sqlgenerator.repository;

import com.energizeglobal.sqlgenerator.domain.IssuerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IssuerRepository extends JpaRepository<IssuerEntity, Long> {
}
