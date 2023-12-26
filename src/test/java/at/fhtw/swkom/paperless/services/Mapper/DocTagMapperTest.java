package at.fhtw.swkom.paperless.services.Mapper;

import at.fhtw.swkom.paperless.persistance.entities.DocTagEntity;
import at.fhtw.swkom.paperless.services.dto.DocTag;
import at.fhtw.swkom.paperless.services.mapper.DocTagMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openapitools.jackson.nullable.JsonNullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class DocTagMapperTest {

    @Autowired
    private DocTagMapper docTagMapper;

    @Test
    public void testEntityToDtoMapping() {
        // Arrange
        DocTagEntity entity = new DocTagEntity();
        entity.setSlug("slugValue");
        entity.setName("nameValue");

        // Act
        DocTag dto = docTagMapper.toDocTag(entity);

        // Assert
        assertEquals(entity.getSlug(), dto.getSlug().orElse(null));
        assertEquals(entity.getName(), dto.getName().orElse(null));

    }

    @Test
    public void testDtoToEntityMapping() {
        // Arrange
        DocTag dto = new DocTag();
        dto.setSlug(JsonNullable.of("slugValue"));
        dto.setName(JsonNullable.of("nameValue"));

        // Act
        DocTagEntity entity = docTagMapper.toDocTagEntity(dto);

        // Assert
        assertEquals(dto.getSlug().orElse(null), entity.getSlug());
        assertEquals(dto.getName().orElse(null), entity.getName());

    }
}

