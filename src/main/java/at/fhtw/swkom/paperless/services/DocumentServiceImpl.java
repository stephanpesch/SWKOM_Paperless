package at.fhtw.swkom.paperless.services;

import at.fhtw.swkom.paperless.persistance.entities.DocumentsDocumentEntity;
import at.fhtw.swkom.paperless.persistance.repositories.DocumentsDocumentRepository;
import at.fhtw.swkom.paperless.services.dto.Document;
import at.fhtw.swkom.paperless.services.mapper.DocumentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.OffsetDateTime;

@Service
public class DocumentServiceImpl implements DocumentService {
    private final DocumentsDocumentRepository documentsDocumentRepository;

    private final DocumentMapper documentMapper;


    // Constructor based dependency injection
    public DocumentServiceImpl(DocumentsDocumentRepository documentsDocumentRepository, DocumentMapper documentMapper, RabbitMQService rabbitMQService) {
        this.documentsDocumentRepository= documentsDocumentRepository;
        this.documentMapper = documentMapper;

    }

    // Method to upload a document setting dummy values for the fields that are not yet implemented
    public void uploadDocument(Document documentDTO,MultipartFile file) {
        documentDTO.setCreated(OffsetDateTime.now());
        documentDTO.setAdded(OffsetDateTime.now());
        documentDTO.setModified(OffsetDateTime.now());
        documentDTO.content("");


        // Convert the DTO to an entity
        DocumentsDocumentEntity documentToBeSaved = documentMapper.dtoToEntity(documentDTO);

        // Set dummy values for the fields that are not yet implemented
        documentToBeSaved.setChecksum("checksum");
        documentToBeSaved.setStorageType("pdf");
        documentToBeSaved.setMimeType("pdf");

        documentsDocumentRepository.save(documentToBeSaved);
    }

}
