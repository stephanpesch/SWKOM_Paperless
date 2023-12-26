package at.fhtw.swkom.paperless.services.Mapper;

import at.fhtw.swkom.paperless.persistance.entities.DocumentEntity;
import at.fhtw.swkom.paperless.services.dto.Document;
import at.fhtw.swkom.paperless.services.mapper.DocumentMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.openapitools.jackson.nullable.JsonNullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class DocumentMapperTest {

    @Autowired
    private DocumentMapper documentMapper;

    @Test
    public void testDocumentMapping() {
        // Create a sample DocumentEntity
        DocumentEntity entity = new DocumentEntity();
        entity.setTitle("paperless");

        // Perform the mapping
        Document dto = documentMapper.toDocumentDTO(entity);

        // Assert the results
        assertEquals(entity.getTitle(), dto.getTitle().orElse(null));

    }

    @Test
    public void testEntityMapping() {
        // Create a sample Document DTO
        Document dto = new Document();
        dto.setTitle(JsonNullable.of("paperless"));

        // Perform the mapping
        DocumentEntity entity = documentMapper.toDocumentEntity(dto);

        // Assert the results
        assertEquals(dto.getTitle().orElse(null), entity.getTitle());
    }
}

