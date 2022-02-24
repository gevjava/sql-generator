package com.energizeglobal.sqlgenerator.repository;

import com.energizeglobal.sqlgenerator.domain.SubIssuer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubIssuerRepository extends JpaRepository<SubIssuer,Long> {

}
//@Modifying
//    @Query("insert into subissuer (name,code,authentMeans)
//    select :name,:code,:authentMeans")
//    public int modifyingQueryInsertSubIssuer(
//    @Param("name")String name,
//    @Param("code")String code,
//    @Param("authentMeans")String authentMeans);