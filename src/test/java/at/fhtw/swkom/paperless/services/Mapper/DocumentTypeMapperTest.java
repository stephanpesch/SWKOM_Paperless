package at.fhtw.swkom.paperless.services.Mapper;
import at.fhtw.swkom.paperless.persistance.entities.DocumentTypeEntity;
import at.fhtw.swkom.paperless.services.dto.DocumentType;
import at.fhtw.swkom.paperless.services.mapper.DocumentTypeMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openapitools.jackson.nullable.JsonNullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class DocumentTypeMapperTest {

    @Autowired
    private DocumentTypeMapper documentTypeMapper;

    @Test
    public void testEntityToDtoMapping() {
        // Arrange
        DocumentTypeEntity entity = new DocumentTypeEntity();
        entity.setSlug("slugValue");
        entity.setName("nameValue");
        entity.setMatch("matchValue");

        // Act
        DocumentType dto = documentTypeMapper.toDocumentTypeDTO(entity);

        // Assert
        assertEquals(entity.getSlug(), dto.getSlug().orElse(null));
        assertEquals(entity.getName(), dto.getName().orElse(null));
        assertEquals(entity.getMatch(), dto.getMatch().orElse(null));
    }

    @Test
    public void testDtoToEntityMapping() {
        // Arrange
        DocumentType dto = new DocumentType();
        dto.setSlug(JsonNullable.of("slugValue"));
        dto.setName(JsonNullable.of("nameValue"));
        dto.setMatch(JsonNullable.of("matchValue"));

        // Act
        DocumentTypeEntity entity = documentTypeMapper.toDocumentTypeEntity(dto);

        // Assert
        assertEquals(dto.getSlug().orElse(null), entity.getSlug());
        assertEquals(dto.getName().orElse(null), entity.getName());
        assertEquals(dto.getMatch().orElse(null), entity.getMatch());
    }
}

