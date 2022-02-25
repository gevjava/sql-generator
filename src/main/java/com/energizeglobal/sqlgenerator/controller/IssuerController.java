package com.energizeglobal.sqlgenerator.controller;

import com.energizeglobal.sqlgenerator.domain.Issuer;
import com.energizeglobal.sqlgenerator.dto.IssuerDTO;
import com.energizeglobal.sqlgenerator.service.IssuerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.ServerRequest;

import java.nio.file.Path;
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

    @PostMapping
    public ResponseEntity<String> generateSqlScript(@RequestBody IssuerDTO issuerDTO){

       String filename = issuerService.generateInsertSqlScript(issuerDTO);

        return ResponseEntity.ok(filename);
    }

    @GetMapping("/script/download/{filename}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String filename){

        Resource file = issuerService.downloadFile(filename);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, "application/sql")
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename="+file.getFilename())
                .body(file);
    }
}
