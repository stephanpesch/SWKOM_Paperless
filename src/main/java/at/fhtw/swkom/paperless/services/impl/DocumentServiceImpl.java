package at.fhtw.swkom.paperless.services.impl;

import at.fhtw.swkom.paperless.persistance.entities.DocumentEntity;
import at.fhtw.swkom.paperless.persistance.repositories.DocumentRepository;
import at.fhtw.swkom.paperless.services.dto.Document;
import at.fhtw.swkom.paperless.services.mapper.DocumentMapper;
import at.fhtw.swkom.paperless.services.mapper.DocumentService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;


@Service
@Data
public abstract class DocumentServiceImpl implements DocumentService {
    private final DocumentRepository documentRepository;
    private final DocumentMapper documentMapper;

    @Autowired
    public DocumentServiceImpl(DocumentRepository documentRepository, DocumentMapper documentMapper) {
        this.documentRepository = documentRepository;
        this.documentMapper = documentMapper;
    }

    @Override
    public Document uploadDocument(MultipartFile file) throws IOException {
        // Check if the file is empty or not
        if (file.isEmpty()) {
            throw new IllegalStateException("Cannot upload an empty file");
        }

        // Create a new Document entity
        DocumentEntity documentEntity = new DocumentEntity();
        documentEntity.setOriginalFileName(file.getOriginalFilename());
        documentEntity.setContent(Arrays.toString(file.getBytes())); // Get the file content

        // Save the document entity to the database
        DocumentEntity savedDocument = documentRepository.save(documentEntity);

        // Convert the saved entity to a DTO
        return documentMapper.toDto(savedDocument);
    }
}
