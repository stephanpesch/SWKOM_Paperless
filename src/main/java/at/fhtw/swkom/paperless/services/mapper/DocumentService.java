package at.fhtw.swkom.paperless.services.mapper;

import at.fhtw.swkom.paperless.persistance.entities.DocumentEntity;
import at.fhtw.swkom.paperless.services.dto.Document;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface DocumentService extends Mapper<DocumentEntity,Document>{
    Document uploadDocument(MultipartFile file) throws IOException;


}
