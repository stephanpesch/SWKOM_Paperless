package at.fhtw.swkom.paperless.services.mapper;

import at.fhtw.swkom.paperless.persistance.entities.CorrespondentEntity;
import at.fhtw.swkom.paperless.services.dto.Correspondent;
import at.fhtw.swkom.paperless.services.mapper.CorrespondentMapper;

import org.springframework.stereotype.Component;


@Component
public class CorrespondentMapperImpl extends AbstractMapper<CorrespondentEntity, Correspondent> implements CorrespondentMapper{

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
