package com.energizeglobal.sqlgenerator.controller;

import com.energizeglobal.sqlgenerator.domain.SubIssuer;
import com.energizeglobal.sqlgenerator.service.SubIssuerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
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

    @PostMapping
    public ResponseEntity<SubIssuer> createSubissuer(@RequestBody SubIssuer subIssuer) throws IOException {
        SubIssuer subIssuer1 = subIssuerServiceImpl.createSubissuer(subIssuer);
        return ResponseEntity.ok(subIssuer1);

    }
//    @PostMapping
//    public void createSubissuer(HttpServletRequest request, HttpServletResponse response) throws IOException {
//
//        PrintWriter writer = response.getWriter();
//        writer.print(request.getReader().readLine());
//        writer.flush();
//    }
}