package com.energizeglobal.sqlgenerator.controller;

import com.energizeglobal.sqlgenerator.domain.IssuerEntity;
import com.energizeglobal.sqlgenerator.dto.IssuerDTO;
import com.energizeglobal.sqlgenerator.service.impl.IssuerServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/issuer")
public class IssuerController {

    private final Logger log = LoggerFactory.getLogger(IssuerController.class);

    private final IssuerServiceImpl issuerServiceImpl;

    public IssuerController(IssuerServiceImpl issuerServiceImpl) {
        this.issuerServiceImpl = issuerServiceImpl;
    }

    @GetMapping
    public ResponseEntity<List<IssuerEntity>> getAllIssuer(){

        List<IssuerEntity> issuerEntityList = issuerServiceImpl.getAllIssuer();

        return ResponseEntity.ok(issuerEntityList);
    }

    @PostMapping
    public ResponseEntity<String> generateSqlScript(@RequestBody IssuerDTO issuerDTO){

       String filename = issuerServiceImpl.generateInsertSqlScript(issuerDTO);

        return ResponseEntity.ok(filename);
    }

    @GetMapping("/script/download/{filename}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String filename){

        Resource file = issuerServiceImpl.getDownloadFileServiceImpl();

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, "application/sql")
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename="+file.getFilename())
                .body(file);
    }
}
