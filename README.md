# PigeonFile

> An ultra-lightweight, self-hosted Spring Boot 4 server designed to securely and soberly synchronize text-based files (Markdown notes, TODO lists, configurations) across your devices as lightly as sending a carrier pigeon would be.

## Concept & Philosophy

Most mainstream cloud storage solutions (Google Drive, OneDrive) or even self-hosted alternatives (Nextcloud) are heavy, resource-intensive infrastructures. They rely on constant network traffic (polling), aggressive server-side indexing, and continuous CPU/RAM overhead just to sync simple lines of text.

PigeonFile takes a lighter and empowering approach:
*   **Total Sovereignty:** Your files physically reside in your living room (on a Raspberry Pi or an old PC). Zero third-party trust, end-to-end control.
*   **Digital Sobriety (Low-Tech):** The server is designed to be purely *stateless* and passive. When there is no active request, its CPU consumption drops to 0%.
*   **Network Optimization:** No blind re-uploading of entire files upon minor edits. The system uses a compressed binary exchange format and a smart SHA-256 hash comparison mechanism to transfer only the strict minimum of bytes.

## Key Differences with Existing Solutions

| Feature | Classic Cloud (e.g., OneDrive) | Nextcloud | PigeonFile (Green-Sync) |
| :--- | :--- | :--- | :--- |
| **Hosting** | Third-party servers / Giant datacenters | Self-hosted (requires an active, heavy server) | **Lightweight self-hosting (runs on a <5W Raspberry Pi)** |
| **Network Behavior** | Telemetry, regular scans, heavy HTTP headers | Regular polling, heavy WebDAV requests | **Fully passive (zero background network traffic)** |
| **File Processing** | Full file re-upload on every save | Often re-uploads the whole modified file | **Delta & hash verification: sends only compressed changes** |
| **System Footprint** | Continuous CPU/RAM consumption | Resource-heavy (PHP / full Database setup) | **Optimized, stateless Spring Boot 4 architecture** |

## Tech Stack & Engineering Choices

This project leverages:

*   **Java 21 & Spring Boot 4.x:** Harnessing the latest virtual machine (JVM) optimizations, fully prepared for GraalVM Native Image compilation to drop the startup memory footprint below 50MB of RAM.
*   **Spring Security & JWT:** Robust, stateless authentication via ephemeral tokens to secure private data access without bloating the server with active session state.
*   **H2 Database (Embedded):** Metadata storage (SHA-256 hashes, sync timestamps, user credentials) directly inside a local file. No heavy database engine (like PostgreSQL/MySQL) running 24/7 in the background.
*   **Spring Boot Actuator:** Out-of-the-box monitoring endpoints to track memory and CPU usage during synchronization phases, enabling continuous Green IT profiling.

## Roadmap

- [x] Initialize Spring Boot 4 server & basic connectivity Ping API.
- [ ] Implement the Security layer (Stateless JWT Authentication).
- [ ] Database setup & SHA-256 file metadata comparison logic.
- [ ] Decompression engine & secure local file storage writing.
- [ ] Lightweight client automation script (on-demand trigger).
- [ ] Active profiling via Spring Actuator.
