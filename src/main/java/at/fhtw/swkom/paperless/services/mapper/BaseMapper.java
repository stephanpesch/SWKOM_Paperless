package at.fhtw.swkom.paperless.services.mapper;

import org.openapitools.jackson.nullable.JsonNullable;



public interface BaseMapper<ENTITY, DTO> {
    DTO entityToDto(ENTITY entity);

    ENTITY dtoToEntity(DTO dto);

    default <T> T map(JsonNullable<T> value) {
        if (value == null || !value.isPresent()) {
            return null;
        }
        return value.get();
    }

    default <T> JsonNullable<T> map(T value) {
        if (value == null) {
            return JsonNullable.undefined();
        }
        return JsonNullable.of(value);
    }


}