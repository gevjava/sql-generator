package com.energizeglobal.sqlgenerator.controller;

import com.energizeglobal.sqlgenerator.domain.AuthentMeansEntity;
import com.energizeglobal.sqlgenerator.dto.AuthentMeansDTO;
import com.energizeglobal.sqlgenerator.service.impl.AuthentMeansServiceImpl;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authent")
public class AuthentMeansController {


    private final AuthentMeansServiceImpl authentMeansService;

    public AuthentMeansController(AuthentMeansServiceImpl authentMeansService) {
        this.authentMeansService = authentMeansService;
    }

    @GetMapping
    private ResponseEntity<List<AuthentMeansEntity>> getAllAuthentMeans() {
        List<AuthentMeansEntity> authentMeansDTOS = authentMeansService.getAllAuthentMeans();
        return ResponseEntity.ok(authentMeansDTOS);
    }

    @GetMapping("/{id}")
    private ResponseEntity<AuthentMeansDTO> getByIdAuthentMean(@PathVariable Long id) {
        AuthentMeansDTO authentMeansDTO = authentMeansService.getByIdAuthentMean(id);
        return ResponseEntity.ok(authentMeansDTO);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity deleteAuthentMeanById(@PathVariable Long id) {
        String filename = authentMeansService.deleteAuthentMeanById(id);
        return ResponseEntity.ok(filename);
    }

    @PostMapping()
    public ResponseEntity<String> saveAuthentMean(@RequestBody AuthentMeansDTO authentMeansDTO) {
        String filename = authentMeansService.saveAuthentMean(authentMeansDTO);
        return ResponseEntity.ok(filename);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateAuthentMean(@RequestBody AuthentMeansDTO authentMeansDTO) {
        String filename = authentMeansService.updateAuthentMean(authentMeansDTO);
        return ResponseEntity.ok(filename);
    }

    @GetMapping("/download/{filename}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String filename) {

        Resource file = authentMeansService.getDownloadFile(filename);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, "application/sql")
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + file.getFilename())
                .body(file);
    }
}
