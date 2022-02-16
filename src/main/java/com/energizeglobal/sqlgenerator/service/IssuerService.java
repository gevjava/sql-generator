package com.energizeglobal.sqlgenerator.service;

import com.energizeglobal.sqlgenerator.domain.Issuer;
import com.energizeglobal.sqlgenerator.repository.IssuerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class IssuerService {

    private final Logger log = LoggerFactory.getLogger(IssuerService.class);

    private final IssuerRepository issuerRepository;

    public IssuerService(IssuerRepository issuerRepository) {
        this.issuerRepository = issuerRepository;
    }

    @Transactional(readOnly = true)
    public List<Issuer> getAllIssuer(){

        List<Issuer> issuerList = issuerRepository.findAll();

        return issuerList;
    }
}
