package com.energizeglobal.sqlgenerator.repository;

import com.energizeglobal.sqlgenerator.domain.CryptoConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CryptoConfigRepository extends JpaRepository<CryptoConfig, Long> {
}
