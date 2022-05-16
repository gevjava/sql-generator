package com.energizeglobal.sqlgenerator.service;

import com.energizeglobal.sqlgenerator.domain.ProfileSet;
import com.energizeglobal.sqlgenerator.repository.ProfileSetRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProfileSetService {

    ProfileSetRepository profileSetRepository;

    public ProfileSetService(ProfileSetRepository profileSetRepository) {
        this.profileSetRepository = profileSetRepository;
    }

    @Transactional
    public List<ProfileSet> getAllProfileSets(){
        return this.profileSetRepository.findAll();
    }
}
