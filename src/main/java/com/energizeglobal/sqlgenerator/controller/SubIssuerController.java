package com.energizeglobal.sqlgenerator.controller;

import com.energizeglobal.sqlgenerator.domain.SubIssuer;
import com.energizeglobal.sqlgenerator.service.SubIssuerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RestController
@RequestMapping("/subissuer")
public class SubIssuerController {
    private final Logger log = LoggerFactory.getLogger(SubIssuerController.class);

    private final SubIssuerService subIssuerServiceImpl;

    public SubIssuerController(SubIssuerService subIssuerServiceImpl) {
        this.subIssuerServiceImpl = subIssuerServiceImpl;
    }

    @GetMapping
    public ResponseEntity<List<SubIssuer>> getAllSubIssuer(){

        List<SubIssuer> subIssuerList = subIssuerServiceImpl.getAllSubIssuer();

        return ResponseEntity.ok(subIssuerList);
    }
}