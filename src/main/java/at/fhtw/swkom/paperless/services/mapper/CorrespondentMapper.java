package at.fhtw.swkom.paperless.services.mapper;


import at.fhtw.swkom.paperless.persistance.entities.CorrespondentEntity;
import at.fhtw.swkom.paperless.services.dto.Correspondent;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import org.openapitools.jackson.nullable.JsonNullable;

import java.util.Collections;
import java.util.List;

@Mapper(componentModel = "spring")
public interface CorrespondentMapper {
    CorrespondentMapper INSTANCE = Mappers.getMapper(CorrespondentMapper.class);

    @Mapping(target = "slug", source = "slug", qualifiedByName = "unwrapString")
    @Mapping(target = "name", source = "name", qualifiedByName = "unwrapString")
    @Mapping(target = "match", source = "match", qualifiedByName = "unwrapString")
    CorrespondentEntity toCorrespondentEntity(Correspondent correspondent);

    @Mapping(target = "slug", source = "slug", qualifiedByName = "wrapString")
    @Mapping(target = "name", source = "name", qualifiedByName = "wrapString")
    @Mapping(target = "match", source = "match", qualifiedByName = "wrapString")
    Correspondent toCorrespondentDTO(CorrespondentEntity correspondentEntity);



    @Named("unwrapString")
    default String unwrapString(JsonNullable<String> jsonNullable) {
        return jsonNullable.orElse(null);
    }


    @Named("wrapString")
    default JsonNullable<String> wrapString(String value) {
        return JsonNullable.of(value);
    }

}
