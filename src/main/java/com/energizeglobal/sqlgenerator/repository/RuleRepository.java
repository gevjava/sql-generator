package com.energizeglobal.sqlgenerator.repository;

import com.energizeglobal.sqlgenerator.domain.RuleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RuleRepository extends JpaRepository<RuleEntity, Long> {

}
