package com.energizeglobal.sqlgenerator.repository;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.Objects;

public class CustomSubissuerRepositoryImpl implements CustomSubissuerRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void deleteByCode(String code) {
        entityManager.createNativeQuery("START TRANSACTION").executeUpdate();
        entityManager.createNativeQuery("SET foreign_key_checks = 0 ").executeUpdate();
        // TODO
//        entityManager.createQuery("DELETE FROM SubIssuer s WHERE s.code = :code")
//                .setParameter("code", s.getCode()).getSingleResult();
        entityManager.createNativeQuery("SET foreign_key_checks = 1 ").executeUpdate();
        entityManager.createNativeQuery("COMMIT").executeUpdate();


    }

    @PostConstruct
    public void postConstruct() {
        Objects.requireNonNull(entityManager);
    }
}

