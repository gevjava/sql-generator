package com.energizeglobal.sqlgenerator.service;

import com.energizeglobal.sqlgenerator.domain.SubIssuer;

import com.energizeglobal.sqlgenerator.repository.SubIssuerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SubIssuerService {

    private final Logger log = LoggerFactory.getLogger(IssuerService.class);

    private final SubIssuerRepository subIssuerRepository;


    public SubIssuerService(SubIssuerRepository subIssuerRepository) {
        this.subIssuerRepository = subIssuerRepository;
    }

    @Transactional(readOnly = true)
    public List<SubIssuer> getAllSubIssuer() {

        List<SubIssuer> subIssuerList = subIssuerRepository.findAll();

        return subIssuerList;
    }
}
