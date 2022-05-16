package com.energizeglobal.sqlgenerator.repository;

import com.energizeglobal.sqlgenerator.domain.ProfileSet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileSetRepository extends JpaRepository<ProfileSet,Long> {
}
