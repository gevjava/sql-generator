package com.energizeglobal.sqlgenerator.controller;

import com.energizeglobal.sqlgenerator.domain.Issuer;
import com.energizeglobal.sqlgenerator.dto.IssuerDTO;
import com.energizeglobal.sqlgenerator.service.IssuerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/issuers")
public class IssuerController {

    private final Logger log = LoggerFactory.getLogger(IssuerController.class);

    private final IssuerService issuerService;

    public IssuerController(IssuerService issuerService) {
        this.issuerService = issuerService;
    }

    @GetMapping
    public ResponseEntity<List<Issuer>> getAllIssuer() {
        List<Issuer> issuerList = issuerService.getAllIssuer();
        return ResponseEntity.ok(issuerList);
    }

    @PostMapping
    public ResponseEntity<String> generateSqlScript(@RequestBody IssuerDTO issuerDTO) {
        String fileName_1 = issuerService.generateInsertSqlScript(issuerDTO);
        String fileName_2 = issuerService.generateInsertSqlScriptWithRollback(issuerDTO);
        return ResponseEntity.ok(fileName_1 + " " + fileName_2);
    }

    @GetMapping("/{code}")
    public ResponseEntity<Issuer> show(@PathVariable("code") String someId) {
        Issuer issuer = issuerService.findByIssuerByCode(someId);
        return ResponseEntity.ok(issuer);
    }

    @PutMapping("/{code}")
    public ResponseEntity<String> edit(@RequestBody IssuerDTO issuerDTO, @PathVariable("code") String code) {
        String fileName_1 = issuerService.generateEditSqlScript(issuerDTO, code);
        String fileName_2 = issuerService.generateEditSqlScriptWithRollback(issuerDTO, code);
        return ResponseEntity.ok(fileName_1 + " " + fileName_2);
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<String> destroy(@PathVariable("code") String code) {
        String fileName_1 = issuerService.generateDeleteSqlScript(code);
        String fileName_2 = issuerService.generateDeleteSqlScriptWithRollback(code);
        return ResponseEntity.ok(fileName_1 + " " + fileName_2);
    }

}
