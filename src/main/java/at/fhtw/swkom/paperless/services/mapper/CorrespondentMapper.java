package at.fhtw.swkom.paperless.services.mapper;

import at.fhtw.swkom.paperless.persistance.entities.CorrespondentEntity;
import at.fhtw.swkom.paperless.services.dto.Correspondent;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;


@Mapper
public class CorrespondentMapper extends AbstractMapper<CorrespondentEntity, Correspondent> implements CorrespondentService {

    @Override
    public Correspondent toDto(CorrespondentEntity entity) {
        return Correspondent.builder()
                .id(entity.getId())
                .slug(entity.getSlug())
                .name(entity.getName())
                .match(entity.getMatch())
                .matchingAlgorithm(entity.getMatchingAlgorithm())
                .isInsensitive(entity.getIsInsensitive())
                .documentCount(entity.getDocumentCount())
                .lastCorrespondence(entity.getLastCorrespondence())
                .build();
    }

    @Override
    public CorrespondentEntity toEntity(Correspondent dto) {
        return CorrespondentEntity.builder()
                .name(dto.getName())
                .match(dto.getMatch())
                .matchingAlgorithm(dto.getMatchingAlgorithm())
                .isInsensitive(dto.getIsInsensitive())
                .documentCount(dto.getDocumentCount())
                .lastCorrespondence(dto.getLastCorrespondence())
                .build();
    }
}
