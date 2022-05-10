package com.energizeglobal.sqlgenerator.controller;

import com.energizeglobal.sqlgenerator.domain.RuleEntity;
import com.energizeglobal.sqlgenerator.dto.RuleDTO;
import com.energizeglobal.sqlgenerator.service.RuleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rule")
public class RuleController {

    private final RuleService ruleService;

    public RuleController(RuleService ruleService) {
        this.ruleService = ruleService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<RuleDTO> getRuleById(@PathVariable Long id) {
        RuleDTO ruleDTO = ruleService.findById(id);
        return ResponseEntity.ok(ruleDTO);
    }

    @GetMapping
    public ResponseEntity<List<RuleEntity>> getAllRules() {
        List<RuleEntity> rulesList = ruleService.getAllRules();
        return ResponseEntity.ok(rulesList);
    }

    @PostMapping
    public ResponseEntity<String> generateSqlScript(@RequestBody RuleDTO ruleDto) {
        String filename = ruleService.generateInsertSqlScript(ruleDto);
        return ResponseEntity.ok(filename);
    }

    @PutMapping
    public ResponseEntity<String> updateRule(@RequestBody RuleDTO ruleDto){
        String filename = ruleService.generateUpdateSqlScript(ruleDto);
        return ResponseEntity.ok(filename);
    }


}
