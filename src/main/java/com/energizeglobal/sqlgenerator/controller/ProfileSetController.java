package com.energizeglobal.sqlgenerator.controller;

import com.energizeglobal.sqlgenerator.domain.ProfileSet;
import com.energizeglobal.sqlgenerator.dto.ProfileSetDTO;
import com.energizeglobal.sqlgenerator.service.ProfileSetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profilesets")
public class ProfileSetController {

    private final ProfileSetService profileSetService;

    public ProfileSetController(ProfileSetService profileSetService) {
        this.profileSetService = profileSetService;
    }

    @GetMapping
    public ResponseEntity<List<ProfileSet>> index(){
        return ResponseEntity.ok(this.profileSetService.getAllProfileSets());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfileSet> show(@PathVariable("id") String id){
        return ResponseEntity.ok(this.profileSetService.getProfileSet(Long.parseLong(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> edit(@RequestBody ProfileSetDTO dto, @PathVariable("id") String id){
        String fileName_1 = this.profileSetService.generateEditSqlScript(dto,id);
        String fileName_2 = this.profileSetService.generateEditSqlScriptWithRollback(dto,id);
        return ResponseEntity.ok((fileName_1 + "__" + fileName_2));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> destroy(@PathVariable("id") String id){
        String fileName_1 = this.profileSetService.generateDeleteSqlScript(id);
        String fileName_2 = this.profileSetService.generateDeleteSqlScriptWithRollback(id);
        return ResponseEntity.ok((fileName_1 + "__" + fileName_2));
    }
}
