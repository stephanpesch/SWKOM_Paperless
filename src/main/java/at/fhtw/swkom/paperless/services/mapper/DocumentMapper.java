package at.fhtw.swkom.paperless.services.mapper;

import at.fhtw.swkom.paperless.persistance.entities.DocumentsDocumentEntity;
import at.fhtw.swkom.paperless.services.dto.Document;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import org.openapitools.jackson.nullable.JsonNullable;
import java.util.Collections;
import java.util.List;

@Mapper(componentModel = "spring")
public interface DocumentMapper {
    DocumentMapper INSTANCE = Mappers.getMapper(DocumentMapper.class);


    // Add mappings for other JsonNullable fields
    @Mapping(target = "correspondent", source = "correspondent", qualifiedByName = "unwrapInteger")
    @Mapping(target = "documentType", source = "documentType", qualifiedByName = "unwrapInteger")
    @Mapping(target = "storagePath", source = "storagePath", qualifiedByName = "unwrapInteger")
    @Mapping(target = "title", source = "title", qualifiedByName = "unwrapString")
    @Mapping(target = "content", source = "content", qualifiedByName = "unwrapString")
    @Mapping(target = "tags", source = "tags", qualifiedByName = "unwrapListInteger")
    @Mapping(target = "archiveSerialNumber", source = "archiveSerialNumber", qualifiedByName = "unwrapString")
    @Mapping(target = "originalFileName", source = "originalFileName", qualifiedByName = "unwrapString")
    @Mapping(target = "archivedFileName", source = "archivedFileName", qualifiedByName = "unwrapString")
    DocumentsDocumentEntity toDocumentEntity(Document document);

    // Inverse mapping
    @Mapping(target = "correspondent", source = "correspondent", qualifiedByName = "wrapInteger")
    @Mapping(target = "documentType", source = "documentType", qualifiedByName = "wrapInteger")
    @Mapping(target = "storagePath", source = "storagePath", qualifiedByName = "wrapInteger")
    @Mapping(target = "title", source = "title", qualifiedByName = "wrapString")
    @Mapping(target = "content", source = "content", qualifiedByName = "wrapString")
    @Mapping(target = "tags", source = "tags", qualifiedByName = "wrapListInteger")
    @Mapping(target = "archiveSerialNumber", source = "archiveSerialNumber", qualifiedByName = "wrapString")
    @Mapping(target = "originalFileName", source = "originalFileName", qualifiedByName = "wrapString")
    @Mapping(target = "archivedFileName", source = "archivedFileName", qualifiedByName = "wrapString")
    Document toDocumentDTO(DocumentsDocumentEntity documentsDocumentEntity);

    // Custom methods to handle JsonNullable unwrapping
    @Named("unwrapInteger")
    default Integer unwrapInteger(JsonNullable<Integer> jsonNullable) {
        return jsonNullable.orElse(null);
    }

    @Named("unwrapString")
    default String unwrapString(JsonNullable<String> jsonNullable) {
        return jsonNullable.orElse(null);
    }

    @Named("unwrapListInteger")
    default List<Integer> unwrapListInteger(JsonNullable<List<Integer>> jsonNullable) {
        return jsonNullable.orElse(Collections.emptyList());
    }


    @Named("wrapInteger")
    default JsonNullable<Integer> wrapInteger(Integer value) {
        return JsonNullable.of(value);
    }

    @Named("wrapString")
    default JsonNullable<String> wrapString(String value) {
        return JsonNullable.of(value);
    }

    @Named("wrapListInteger")
    default JsonNullable<List<Integer>> wrapListInteger(List<Integer> value) {
        return JsonNullable.of(value);
    }

}
