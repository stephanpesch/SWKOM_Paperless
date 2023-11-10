package at.fhtw.swkom.paperless.services.mapper;

import at.fhtw.swkom.paperless.persistance.entities.DocumentEntity;
import at.fhtw.swkom.paperless.persistance.repositories.CorrespondentRepository;
import at.fhtw.swkom.paperless.persistance.repositories.DocumentRepository;
import at.fhtw.swkom.paperless.services.dto.Document;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.openapitools.jackson.nullable.JsonNullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Mapper(componentModel = "spring")
@Component
public abstract class DocumentMapper extends AbstractMapper<DocumentEntity, Document> implements DocumentService{

   public static DocumentMapper INSTANCE = Mappers.getMapper(DocumentMapper.class);

   @Autowired
   private DocumentRepository documentRepository;

   @Autowired
   private CorrespondentRepository correspondentRepository;

  /*  @Override
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
    }*/

    @Mapping(target = "correspondent", source ="correspondent",qualifiedByName = "Correspondent")
    @Mapping(target = "documentType", source ="documentType",qualifiedByName = "DocumentType")
    @Mapping(target = "tags", source ="tags",qualifiedByName = "DocTag")
    abstract public Document entityToDto(DocumentEntity entity);

    @Mapping(target = "correspondent", source ="correspondent",qualifiedByName = "CorrespondentEntity")
    @Mapping(target = "documentType", source ="documentType",qualifiedByName = "DocumentTypeEntity")
    @Mapping(target = "tags", source ="tags",qualifiedByName = "DocTagEntity")
    abstract public DocumentEntity dtoToEntity(Document dto);

    @Override
    public Document uploadDocument(MultipartFile file) {
        return null;
    }
}
