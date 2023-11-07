package at.fhtw.swkom.paperless.controller;


import at.fhtw.swkom.paperless.services.dto.Document;
import at.fhtw.swkom.paperless.services.mapper.DocumentService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;

@Data
@RestController
@RequestMapping("/api/documents")
public class DocumentController {
    private final DocumentService documentService;

    @Autowired
    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @PostMapping("/upload")
    public ResponseEntity<Document> uploadDocument(@RequestParam("file") MultipartFile file) throws IOException {
        Document documentDTO = documentService.uploadDocument(file);

        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(documentDTO.getId())
                        .toUri())
                .body(documentDTO);
    }
}

