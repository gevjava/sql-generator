package com.energizeglobal.sqlgenerator.repository;


import com.energizeglobal.sqlgenerator.domain.IssuerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IssuerRepository extends JpaRepository<IssuerEntity, Long> {
    @Query("SELECT i FROM IssuerEntity i WHERE i.code = ?1")
    IssuerEntity getIssuerByCode(String code);
}
