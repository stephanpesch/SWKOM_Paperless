package at.fhtw.swkom.paperless.services;

import at.fhtw.swkom.paperless.services.dto.Document;
import org.springframework.web.multipart.MultipartFile;

public interface DocumentService {

    void uploadDocument(Document documentDTO, MultipartFile file);
}
