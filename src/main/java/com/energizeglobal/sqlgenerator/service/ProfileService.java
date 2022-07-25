package com.energizeglobal.sqlgenerator.service;

import com.energizeglobal.sqlgenerator.domain.Profile;
import com.energizeglobal.sqlgenerator.dto.ProfileDTO;
import com.energizeglobal.sqlgenerator.repository.ProfileRepository;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;
import static java.nio.file.StandardOpenOption.APPEND;

@Service
public class ProfileService {

    private final String FILE_PATH = "src/main/resources/sql_scripts/";
    private final String DATA_FILE_NAME = "profile_data.sql";
    private final String DATA_ROLLBACK_FILE_NAME = "profile_rollback_data.sql";

    private ProfileRepository repository;

    public ProfileService(ProfileRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<Profile> getAllProfiles(){
        List<Profile> profiles = this.repository.findAll();
        return profiles;
    }


    public Profile findByProfileById(long id) {
        Profile profile = this.repository.getProfileById(id);
        return profile;
    }

    public String generateInsertSqlScript(ProfileDTO dto) {
        String Insert = "";
        String path = FILE_PATH + DATA_FILE_NAME;
        return this.storeQueryInFile(path, Insert);
    }

    public String generateInsertSqlScriptWithRollback(ProfileDTO dto) {
        String delete = "";
        String path = FILE_PATH + DATA_ROLLBACK_FILE_NAME;
        return this.storeQueryInFile(path, delete);
    }

    public String generateEditSqlScript(ProfileDTO dto, long id) {
        String sql = "";
        String path = FILE_PATH + DATA_FILE_NAME;
        return this.storeQueryInFile(path, sql);
    }

    public String generateEditSqlScriptWithRollback(ProfileDTO dto, long id) {
        String sql = "";
        String path = FILE_PATH + DATA_ROLLBACK_FILE_NAME;
        return this.storeQueryInFile(path, sql);
    }

    public String generateDeleteSqlScript(long id) {
        String sql = "";
        String path = FILE_PATH + DATA_FILE_NAME;
        return this.storeQueryInFile(path, sql);
    }

    public String generateDeleteSqlScriptWithRollback(long id) {
        String sql = "";
        String path = FILE_PATH + DATA_ROLLBACK_FILE_NAME;
        return this.storeQueryInFile(path, sql);
    }

    private String storeQueryInFile(String path, String sql) {

        Path newFilePath = Paths.get(path);
        try {
            if (Files.exists(newFilePath)) {
                sql = System.getProperty("line.separator") + sql;
                try (BufferedWriter bufferedWriter = Files.newBufferedWriter(newFilePath, UTF_8, APPEND)) {
                    bufferedWriter.write(sql);
                }

            } else {
                Path fileDirectory = Paths.get(FILE_PATH);
                Files.createDirectories(fileDirectory);
                try (BufferedWriter bufferedWriter = Files.newBufferedWriter(newFilePath, UTF_8)) {
                    bufferedWriter.write(sql);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return DATA_FILE_NAME;
    }

    public Resource downloadFile(String filename) {
        try {
            Path file = Paths.get(FILE_PATH).resolve(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("Could not read the file!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }
}
