package at.fhtw.swkom.paperless.services.Mapper;
/*
import at.fhtw.swkom.paperless.persistance.entities.CorrespondentEntity;
import at.fhtw.swkom.paperless.services.dto.Correspondent;
import at.fhtw.swkom.paperless.services.mapper.CorrespondentMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openapitools.jackson.nullable.JsonNullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CorrespondentMapperTest {

    @Autowired
    private CorrespondentMapper correspondentMapper;

    @Test
    public void testEntityToDtoMapping() {
        // Arrange
        CorrespondentEntity entity = new CorrespondentEntity();
        entity.setSlug("slugValue");
        entity.setName("nameValue");

        // Act
        Correspondent dto = correspondentMapper.toCorrespondentDTO(entity);

        // Assert
        assertEquals(entity.getSlug(), dto.getSlug().orElse(null));
        assertEquals(entity.getName(), dto.getName().orElse(null));

    }

    @Test
    public void testDtoToEntityMapping() {
        // Arrange
        Correspondent dto = new Correspondent();
        dto.setSlug(JsonNullable.of("slugValue"));
        dto.setName(JsonNullable.of("nameValue"));

        // Act
        CorrespondentEntity entity = correspondentMapper.toCorrespondentEntity(dto);

        // Assert
        assertEquals(dto.getSlug().orElse(null), entity.getSlug());
        assertEquals(dto.getName().orElse(null), entity.getName());

    }
}


 */