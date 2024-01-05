package at.fhtw.swkom.paperless.services.mapper;


//import at.fhtw.swkom.paperless.persistance.entities.DocTagEntity;
import at.fhtw.swkom.paperless.services.dto.DocTag;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import org.openapitools.jackson.nullable.JsonNullable;
/*

@Mapper(componentModel = "spring")
public interface DocTagMapper {
    DocTagMapper INSTANCE = Mappers.getMapper(DocTagMapper.class);

    @Mapping(target = "slug", source = "slug", qualifiedByName = "unwrapString")
    @Mapping(target = "name", source = "name", qualifiedByName = "unwrapString")
    @Mapping(target = "color", source = "color", qualifiedByName = "unwrapString")
    @Mapping(target = "match", source = "match", qualifiedByName = "unwrapString")
    DocTagEntity toDocTagEntity(DocTag docTag);

    @Mapping(target = "slug", source = "slug", qualifiedByName = "wrapString")
    @Mapping(target = "name", source = "name", qualifiedByName = "wrapString")
    @Mapping(target = "color", source = "color", qualifiedByName = "wrapString")
    @Mapping(target = "match", source = "match", qualifiedByName = "wrapString")
    DocTag toDocTag(DocTagEntity docTagEntity);

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