package at.fhtw.swkom.paperless.services.mapper;

import at.fhtw.swkom.paperless.persistance.entities.DocumentEntity;
import at.fhtw.swkom.paperless.services.dto.Document;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.openapitools.jackson.nullable.JsonNullable;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Mapper
@Component
public class DocumentMapper extends AbstractMapper<DocumentEntity, Document> implements DocumentService{

   public static DocumentMapper INSTANCE = Mappers.getMapper(DocumentMapper.class);

    @Override
    public Document toDto(DocumentEntity entity) {
        return Document.builder()
                .id(entity.getId())
                .correspondent(JsonNullable.of(entity.getCorrespondent()))
                .documentType(JsonNullable.of(entity.getDocumentType()))
                .storagePath(JsonNullable.of(entity.getStoragePath()))
                .title(JsonNullable.of(entity.getTitle()))
                .content(JsonNullable.of(entity.getContent()))
                .tags(JsonNullable.of(entity.getTags()))
                .created(entity.getCreated())
                .createdDate(entity.getCreatedDate())
                .modified(entity.getModified())
                .added(entity.getAdded())
                .archiveSerialNumber(JsonNullable.of(entity.getArchiveSerialNumber()))
                .originalFileName(JsonNullable.of(entity.getOriginalFileName()))
                .archivedFileName(JsonNullable.of(entity.getArchivedFileName()))
                .build();
    }

    @Override
    public DocumentEntity toEntity(Document dto) {
        return DocumentEntity.builder()
                .id(dto.getId())
                .correspondent(dto.getCorrespondent().get())
                .documentType(dto.getDocumentType().get())
                .storagePath(dto.getStoragePath().get())
                .title(dto.getTitle().get())
                .content(dto.getContent().get())
                .tags(dto.getTags().get())
                .created(dto.getCreated())
                .createdDate(dto.getCreatedDate())
                .modified(dto.getModified())
                .added(dto.getAdded())
                .archiveSerialNumber(dto.getArchiveSerialNumber().get())
                .originalFileName(dto.getOriginalFileName().get())
                .archivedFileName(dto.getArchivedFileName().get())
                .build();
    }

    @Override
    public Document uploadDocument(MultipartFile file) {
        return null;
    }
}