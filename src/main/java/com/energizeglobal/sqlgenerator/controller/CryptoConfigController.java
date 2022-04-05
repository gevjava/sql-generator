package com.energizeglobal.sqlgenerator.controller;

import com.energizeglobal.sqlgenerator.dto.CryptoConfigDTO;
import com.energizeglobal.sqlgenerator.service.impl.CryptoConfigServiceImpl;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/crypto")
public class CryptoConfigController {
    private final CryptoConfigServiceImpl cryptoConfigServiceImpl;

    public CryptoConfigController(CryptoConfigServiceImpl cryptoConfigServiceImpl) {
        this.cryptoConfigServiceImpl = cryptoConfigServiceImpl;
    }

    @GetMapping
    private ResponseEntity<List<CryptoConfigDTO>> getAllCryptoConfigs() {
        List<CryptoConfigDTO> cryptoConfigDTOS = cryptoConfigServiceImpl.findAllCryptoConfigs();
        return ResponseEntity.ok(cryptoConfigDTOS);
    }

    @GetMapping("/{id}")
    private ResponseEntity<CryptoConfigDTO> getById(@PathVariable Long id) {
        CryptoConfigDTO cryptoConfigDTO = cryptoConfigServiceImpl.getById(id);
        return ResponseEntity.ok(cryptoConfigDTO);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity deleteById(@PathVariable Long id) {
        String filename = cryptoConfigServiceImpl.deleteById(id);
        return ResponseEntity.ok(filename);
    }

    @PostMapping()
    public ResponseEntity<String> saveCryptoConfig(@RequestBody CryptoConfigDTO cryptoConfigDTO) {
        String filename = cryptoConfigServiceImpl.saveCryptoConfig(cryptoConfigDTO);
        return ResponseEntity.ok(filename);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateCryptoConfig(@RequestBody CryptoConfigDTO cryptoConfigDTO) {
        String filename = cryptoConfigServiceImpl.updateCryptoConfig(cryptoConfigDTO);
        return ResponseEntity.ok(filename);
    }

    @GetMapping("/download/{filename}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String filename) {

        Resource file = cryptoConfigServiceImpl.getDownloadFile(filename);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, "application/sql")
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + file.getFilename())
                .body(file);
    }
}
