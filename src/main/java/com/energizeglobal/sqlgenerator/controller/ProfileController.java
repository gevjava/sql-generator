package com.energizeglobal.sqlgenerator.controller;

import com.energizeglobal.sqlgenerator.domain.Profile;
import com.energizeglobal.sqlgenerator.dto.ProfileDTO;
import com.energizeglobal.sqlgenerator.service.ProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profiles")
public class ProfileController {

    private final ProfileService service;

    public ProfileController(ProfileService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Profile>> index() {
        return ResponseEntity.ok(this.service.getAllProfiles());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Profile> show(@PathVariable("id") String id){return ResponseEntity.ok(this.service.getProfile(Long.parseLong(id)));}

    @PutMapping("/{id}")
    public ResponseEntity<String> edit(@RequestBody ProfileDTO profileDto, @PathVariable("id") String id){
          String fileName_1 = this.service.generateEditSqlScript(profileDto,id);
          String fileName_2 = this.service.generateEditSqlScriptWithRollback(profileDto,id);
          return ResponseEntity.ok(fileName_1 + "__" + fileName_2);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> destroy(@PathVariable String id){
          String fileName_1 = this.service.generateDeleteSqlScript(id);
          String fileName_2 = this.service.generateDeleteSqlScriptWithRollback(id);
          return ResponseEntity.ok(fileName_1 + "__" + fileName_2);
    }

}
