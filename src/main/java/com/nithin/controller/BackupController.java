package com.nithin.controller;

import com.nithin.service.BackUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/backup")
public class BackupController {

    @Autowired
    private BackUpService backupService;

    @PostMapping("/create")
    public ResponseEntity<String> createBackup() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
        String timestamp = dateFormat.format(new Date());
        String backupFileName = "backup_" + timestamp + ".sql";
        String backupFolderPath = "C:\\Users\\varsh\\OneDrive\\Desktop\\BACK_UP";
        Path backupFilePath = Paths.get(backupFolderPath, backupFileName);

        // Specify the parameters required for the backup
        String dumpExePath = "C:\\Users\\varsh\\OneDrive\\Desktop\\BACK_UP\\mysqldump.exe"; // Path to mysqldump executable
        String host = "localhost"; // MySQL host
        String port = "3306"; // MySQL port
        String user = "root"; // MySQL username
        String password = ""; // MySQL password
        String database = "GT"; // Database name
        String backupPath = backupFilePath.toString(); // Backup file path

        // Create the backup
        boolean backupStatus = backupService.backupDataWithDatabase(dumpExePath, host, port, user, password, database, backupPath);

        if (backupStatus) {
            return ResponseEntity.ok().body("Backup created successfully: " + backupFilePath.toString());
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create backup");
        }
    }
}

