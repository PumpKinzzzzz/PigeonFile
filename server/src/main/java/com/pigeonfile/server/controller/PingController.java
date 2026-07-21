package com.pigeonfile.server.controller;

import com.pigeonfile.server.model.FileMetadata;
import com.pigeonfile.server.repository.FileMetadataRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PingController {

    private final FileMetadataRepository fileRepository;

    public PingController(FileMetadataRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    @GetMapping("/ping")
    public List<FileMetadata> ping() {
        String uniqueFilename = "notes/pigeon_" + System.currentTimeMillis() + ".md";

        FileMetadata dummyFile = new FileMetadata(
                uniqueFilename,
                "e3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855", LocalDateTime.now()
        );

        fileRepository.save(dummyFile);

        return fileRepository.findAll();
    }
}