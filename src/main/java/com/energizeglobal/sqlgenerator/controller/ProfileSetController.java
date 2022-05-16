package com.energizeglobal.sqlgenerator.controller;

import com.energizeglobal.sqlgenerator.domain.ProfileSet;
import com.energizeglobal.sqlgenerator.service.ProfileSetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
