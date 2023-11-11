package at.fhtw.swkom.paperless.services.mapper;

import at.fhtw.swkom.paperless.persistance.entities.DocumentEntity;
import at.fhtw.swkom.paperless.services.dto.Document;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DocumentMapper {
    DocumentMapper INSTANCE = Mappers.getMapper(DocumentMapper.class);

    //@Mapping(target = "correspondent", expression = "java(document.getCorrespondent().orElse(null))")
    //@Mapping(target = "documentType", expression = "java(document.getDocumentType().orElse(null))")
    //@Mapping(target = "storagePath", expression = "java(document.getStoragePath().orElse(null))")
    //@Mapping(target = "tags", expression = "java(document.getTags().orElse(null))")
        // Add mappings for other JsonNullable fields
    DocumentEntity toDocumentEntity(Document document);

    // Inverse mapping
    Document fromDocumentEntity(DocumentEntity documentEntity);
}
