package at.fhtw.swkom.paperless.services.mapper;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractMapper <ENTITY, DTO> implements Mapper<ENTITY, DTO> {

    public final List<DTO> toDto(List<ENTITY> entities) {
        List<DTO> dtos = new ArrayList<>();
        entities.forEach(e -> dtos.add(toDto(e)));
        return dtos;
    }
}
