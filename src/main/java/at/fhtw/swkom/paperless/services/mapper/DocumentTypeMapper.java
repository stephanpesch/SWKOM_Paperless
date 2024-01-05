package at.fhtw.swkom.paperless.services.mapper;

/*

import at.fhtw.swkom.paperless.persistance.entities.DocumentTypeEntity;
import at.fhtw.swkom.paperless.services.dto.DocumentType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import org.openapitools.jackson.nullable.JsonNullable;

@Mapper(componentModel = "spring")
public interface DocumentTypeMapper {
    DocumentTypeMapper INSTANCE = Mappers.getMapper(DocumentTypeMapper.class);

    @Mapping(target = "slug", source = "slug", qualifiedByName = "unwrapString")
    @Mapping(target = "name", source = "name", qualifiedByName = "unwrapString")
    @Mapping(target = "match", source = "match", qualifiedByName = "unwrapString")
    DocumentTypeEntity toDocumentTypeEntity(DocumentType documentType);

    @Mapping(target = "slug", source = "slug", qualifiedByName = "wrapString")
    @Mapping(target = "name", source = "name", qualifiedByName = "wrapString")
    @Mapping(target = "match", source = "match", qualifiedByName = "wrapString")
    DocumentType toDocumentTypeDTO(DocumentTypeEntity documentTypeEntity);

    @Named("unwrapString")
    default String unwrapString(JsonNullable<String> jsonNullable) {
        return jsonNullable.orElse(null);
    }


    @Named("wrapString")
    default JsonNullable<String> wrapString(String value) {
        return JsonNullable.of(value);
    }
}


 */