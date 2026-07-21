package com.pigeonfile.server.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "file_metadata")
public class FileMetadata {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String filepath;

    @Column(nullable = false)
    private String hash;

    @Column(nullable = false)
    private LocalDateTime lastModifiedAt;

    public FileMetadata() {}

    public FileMetadata(String filepath, String hash, LocalDateTime lastModifiedAt) {
        this.filepath = filepath;
        this.hash = hash;
        this.lastModifiedAt = lastModifiedAt;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFilepath() { return filepath; }
    public void setFilepath(String filepath) { this.filepath = filepath; }

    public String getHash() { return hash; }
    public void setHash(String hash) { this.hash = hash; }

    public LocalDateTime getLastModifiedAt() { return lastModifiedAt; }
    public void setLastModifiedAt(LocalDateTime lastModifiedAt) { this.lastModifiedAt = lastModifiedAt; }
}