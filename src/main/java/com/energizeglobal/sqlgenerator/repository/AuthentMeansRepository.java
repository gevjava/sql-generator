package com.energizeglobal.sqlgenerator.repository;

import com.energizeglobal.sqlgenerator.domain.AuthentMeans;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface AuthentMeansRepository extends JpaRepository<AuthentMeans, Long> {

}
