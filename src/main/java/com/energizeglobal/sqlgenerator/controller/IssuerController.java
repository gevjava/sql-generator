package com.energizeglobal.sqlgenerator.controller;

import com.energizeglobal.sqlgenerator.domain.Issuer;
import com.energizeglobal.sqlgenerator.service.IssuerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/issuer")
public class IssuerController {

    private final Logger log = LoggerFactory.getLogger(IssuerController.class);

    private final IssuerService issuerService;

    public IssuerController(IssuerService issuerService) {
        this.issuerService = issuerService;
    }

    @GetMapping
    public ResponseEntity<List<Issuer>> getAllIssuer(){

        List<Issuer> issuerList = issuerService.getAllIssuer();

        return ResponseEntity.ok(issuerList);
    }
}
