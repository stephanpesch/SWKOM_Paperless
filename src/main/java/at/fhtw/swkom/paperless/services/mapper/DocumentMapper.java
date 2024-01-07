package at.fhtw.swkom.paperless.services.mapper;
import at.fhtw.swkom.paperless.persistance.entities.*;
import at.fhtw.swkom.paperless.persistance.repositories.*;
import at.fhtw.swkom.paperless.services.dto.Correspondent;
import at.fhtw.swkom.paperless.services.dto.Document;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import org.openapitools.jackson.nullable.JsonNullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
@Service
public abstract class DocumentMapper implements BaseMapper<DocumentsDocumentEntity,Document>{

    @Autowired
    private DocumentsCorrespondentRepository documentsCorrespondentRepository;
    @Autowired
    private DocumentsDocumentTypeRepository documentsDocumentTypeRepository;
    @Autowired
    private DocumentsStoragePathRepository documentsStoragePathRepository;
    @Autowired
    private AuthUserRepository authUserRepository;
    @Autowired
    private DocumentsTagRepository documentsTagRepository;

    @Mapping(target = "correspondent", source = "correspondent", qualifiedByName = "DocumentsCorrespondent")
    @Mapping(target = "documentType", source = "documentType", qualifiedByName = "DocumentsDocumentType")
    @Mapping(target = "storagePath", source = "storagePath", qualifiedByName = "DocumentsStoragePath")
    @Mapping(target = "tags", source = "documentsTag", qualifiedByName = "DocumentsTag")
    @Mapping(target = "createdDate", source = "created", qualifiedByName = "createdToCreatedDate")
    public abstract Document entityToDto(DocumentsDocumentEntity entity);

    @Mapping(target = "correspondent", source = "correspondent", qualifiedByName = "CorrespondentDTO")
    @Mapping(target = "documentType", source = "documentType", qualifiedByName = "DocumentsDocumentTypeDTO")
    @Mapping(target = "storagePath", source = "storagePath", qualifiedByName = "DocumentsStoragePathDTO")
    @Mapping(target = "documentsTag", source = "tags", qualifiedByName = "tagsDTO")
    @Mapping(target = "archiveSerialNumber", source = "archiveSerialNumber", qualifiedByName = "ArchiveSerialNumberDTO")
    public abstract DocumentsDocumentEntity dtoToEntity(Document dto);

    @Named("DocumentsCorrespondent")
    JsonNullable<Integer> map(DocumentsCorrespondentEntity correspondent) {
        return correspondent!=null ? JsonNullable.of(correspondent.getId()) : JsonNullable.undefined();
    }

    @Named("DocumentsDocumentType")
    JsonNullable<Integer> map(DocumentsDocumentTypeEntity documentType) {
        return documentType!=null ? JsonNullable.of(documentType.getId()) : JsonNullable.undefined();
    }

    @Named("DocumentsStoragePath")
    JsonNullable<Integer> map(DocumentsStoragePathEntity storagePath) {
        return storagePath!=null ? JsonNullable.of(storagePath.getId()) : JsonNullable.undefined();
    }

    @Named("owner")
    JsonNullable<Integer> map(AuthUserEntity owner) {
        return owner!=null ? JsonNullable.of(owner.getId()) : JsonNullable.undefined();
    }

    @Named("tags")
    JsonNullable<List<Integer>> map(Set<DocumentsDocumentTagsEntity> tags) {
        return tags!=null ? JsonNullable.of( tags.stream().map( tag->(int)tag.getId() ).toList() ) : JsonNullable.undefined();
    }

    // map created to createdDate (Date without the time)
    @Named("createdToCreatedDate")
    OffsetDateTime mapCreatedDate(OffsetDateTime value) {
        return value!=null ? value.withOffsetSameInstant(ZoneOffset.UTC).toLocalDate().atStartOfDay().atOffset(ZoneOffset.UTC) : null;
    }

    @Named("correspondentDto")
    DocumentsCorrespondentEntity mapCorrespondent(JsonNullable<Integer> value) {
        if(value==null || !value.isPresent() || value.get()==null) return null;

        return documentsCorrespondentRepository.findById(value.get()).orElse(null);
    }

    @Named("documentTypeDto")
    DocumentsDocumentTypeEntity mapDocumentType(JsonNullable<Integer> value) {
        if(value==null || !value.isPresent() || value.get()==null) return null;

        return documentsDocumentTypeRepository.findById(value.get()).orElse(null);
    }

    @Named("storagePathDto")
    DocumentsStoragePathEntity mapStoragePath(JsonNullable<Integer> value) {
        if(value==null || !value.isPresent() || value.get()==null) return null;

        return documentsStoragePathRepository.findById(value.get()).orElse(null);
    }

    @Named("ownerDto")
    AuthUserEntity mapOwner(JsonNullable<Integer> value) {
        if(value==null || !value.isPresent() || value.get()==null) return null;

        return authUserRepository.findById(value.get()).orElse(null);
    }

    @Named("tagsDto")
    Set<DocumentsTagEntity> mapDocTag(JsonNullable<List<Integer>> value) {
        if(value==null || !value.isPresent() || value.get()==null) return null;

        return new HashSet<DocumentsTagEntity>(documentsTagRepository.findAllById(value.get()));
    }

    @Named("archiveSerialNumberDto")
    Integer mapArchiveSerialNumber(JsonNullable<String> value) {
        if(value==null || !value.isPresent() || value.get()==null) return null;
        return Integer.parseInt(value.get());
    }

}

