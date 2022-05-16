package com.energizeglobal.sqlgenerator.service;

import com.energizeglobal.sqlgenerator.domain.Profile;
import com.energizeglobal.sqlgenerator.dto.ProfileDTO;
import com.energizeglobal.sqlgenerator.repository.ProfileRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.List;

@Service
public class ProfileService {

    private String FILE_PATH = "src/main/resources/sql_scripts/";
    private String DATA_FILE_NAME = "insert_query.sql";
    private String DATA_ROLLBACK_FILE_NAME = "rollback_query.sql";

    private ProfileRepository profileRepository;

    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Transactional
    public List<Profile> getAllProfiles(){
       return  this.profileRepository.findAll();
    }

    @Transactional
    public Profile getProfile(long id){ return this.profileRepository.getProfileById(id);}

    public String generateEditSqlScript(ProfileDTO dto, String id) {
        LocalDateTime date = LocalDateTime.ofInstant(dto.getCreationDate(), ZoneId.of(ZoneOffset.UTC.getId()));
        String sql = "UPDATE Profile SET " + "createdBy='" + dto.getCreatedBy() + "', " + "creationDate='" + date + "' ," + "name='" + dto.getName() + "', " + "updateState='" + dto.getUpdateState() + "'  WHERE id = '"+ id +"';";
        String path = FILE_PATH + DATA_FILE_NAME;
        return this.storeQueryInFile(path, sql);
    }

    public String generateEditSqlScriptWithRollback(ProfileDTO dto, String id) {
        Profile profile = this.profileRepository.getProfileById(Long.parseLong(id));
        String sql = "UPDATE Profile SET " + "createdBy='" + profile.getCreatedBy() + "', " + "creationDate='" + LocalDateTime.ofInstant(profile.getCreationDate(), ZoneId.of(ZoneOffset.UTC.getId())) + "' ," + "name='" + profile.getName() + "', " + "updateState='" + profile.getUpdateState() + "' " + " WHERE id='" + id + "';";
        String path = FILE_PATH + DATA_ROLLBACK_FILE_NAME;
        return this.storeQueryInFile(path, sql);
    }

    public String generateDeleteSqlScript(String id) {
        String sql = "DELETE FROM Profile  WHERE id='" + id + "';";
        String path = FILE_PATH + DATA_FILE_NAME;
        return this.storeQueryInFile(path, sql);
    }

    public String generateDeleteSqlScriptWithRollback(String id) {
        Profile profile = this.profileRepository.getProfileById(Long.parseLong(id));
        LocalDateTime date = LocalDateTime.ofInstant(profile.getCreationDate(), ZoneId.of(ZoneOffset.UTC.getId()));
        String sql = "INSERT INTO Profile (createdBy,creationDate, name, updateState) VALUES ('" + profile.getCreatedBy() + "','" + date + "','" + profile.getName() + "','" + profile.getUpdateState() + "' );";
        String path = FILE_PATH + DATA_ROLLBACK_FILE_NAME;
        return this.storeQueryInFile(path, sql);
    }

    private String storeQueryInFile(String path, String sql) {

        Path newFilePath = Paths.get(path);
        try {
            if (Files.exists(newFilePath)) {
                sql = System.getProperty("line.separator") + sql;
                Files.write(newFilePath, sql.getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
            } else {
                Path fileDiectory = Paths.get(FILE_PATH);
                Files.createDirectories(fileDiectory);
                Files.write(newFilePath, sql.getBytes(StandardCharsets.UTF_8));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return DATA_FILE_NAME;
    }
}
