package com.energizeglobal.sqlgenerator.service;

import com.energizeglobal.sqlgenerator.domain.ProfileSet;;
import com.energizeglobal.sqlgenerator.dto.ProfileSetDTO;
import com.energizeglobal.sqlgenerator.repository.ProfileSetRepository;
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
public class ProfileSetService {

    private String FILE_PATH = "src/main/resources/sql_scripts/";
    private String DATA_FILE_NAME = "insert_query.sql";
    private String DATA_ROLLBACK_FILE_NAME = "rollback_query.sql";

    ProfileSetRepository profileSetRepository;

    public ProfileSetService(ProfileSetRepository profileSetRepository) {
        this.profileSetRepository = profileSetRepository;
    }

    @Transactional
    public List < ProfileSet > getAllProfileSets() {
        return this.profileSetRepository.findAll();
    }

    @Transactional
    public ProfileSet getProfileSet(long id) {
        return this.profileSetRepository.getProfileSetById(id);
    }

    public String generateEditSqlScript(ProfileSetDTO dto, String id) {
        LocalDateTime date = LocalDateTime.ofInstant(dto.getCreationDate(), ZoneId.of(ZoneOffset.UTC.getId()));
        String sql = "UPDATE Profileset SET " + "createdBy='" + dto.getCreatedBy() + "', " + "creationDate='" + date + "' ," + "name='" + dto.getName() + "', " + "updateState='" + dto.getUpdateState() + "'  WHERE id = '" + id + "';";
        String path = FILE_PATH + DATA_FILE_NAME;
        return this.storeQueryInFile(path, sql);
    }

    public String generateEditSqlScriptWithRollback(ProfileSetDTO dto, String id) {
        ProfileSet profileSet = this.profileSetRepository.getProfileSetById(Long.parseLong(id));
        String sql = "UPDATE Profileset SET " + "createdBy='" + profileSet.getCreatedBy() + "', " + "creationDate='" + LocalDateTime.ofInstant(profileSet.getCreationDate(), ZoneId.of(ZoneOffset.UTC.getId())) + "' ," + "name='" + profileSet.getName() + "', " + "updateState='" + profileSet.getUpdateState() + "' " + " WHERE id='" + id + "';";
        String path = FILE_PATH + DATA_ROLLBACK_FILE_NAME;
        return this.storeQueryInFile(path, sql);
    }

    public String generateDeleteSqlScript(String id) {
        String sql = "DELETE FROM Profileset  WHERE id='" + id + "';";
        String path = FILE_PATH + DATA_FILE_NAME;
        return this.storeQueryInFile(path, sql);
    }

    public String generateDeleteSqlScriptWithRollback(String id) {
        ProfileSet profileSet = this.profileSetRepository.getProfileSetById(Long.parseLong(id));
        LocalDateTime date = LocalDateTime.ofInstant(profileSet.getCreationDate(), ZoneId.of(ZoneOffset.UTC.getId()));
        String sql = "INSERT INTO Profileset (createdBy,creationDate, name, updateState) VALUES ('" + profileSet.getCreatedBy() + "','" + date + "','" + profileSet.getName() + "','" + profileSet.getUpdateState() + "' );";
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