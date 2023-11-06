package at.fhtw.swkom.paperless.persistance.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
/*
class DocumentEntityTest {

    private DocumentEntity documentEntity;

    private List<String> tags;

    @BeforeEach
    void setUp() {
        tags = new ArrayList<>();
        tags.add("Tag 1");
        tags.add("Tag 2");
        tags.add("Tag 3");

        // Create a new DocumentEntity instance before each test
        documentEntity = DocumentEntity.builder()
                .id(1L)
                .correspondent(123)
                .documentType(456)
                .storagePath(789)
                .title("Test Document")
                .content("This is a test document.")
                .tags(tags)
                .created(OffsetDateTime.now())
                .createdDate(OffsetDateTime.now())
                .modified(OffsetDateTime.now())
                .added(OffsetDateTime.now())
                .archiveSerialNumber("ABC123")
                .originalFileName("test.doc")
                .archivedFileName("test_archived.doc")
                .build();
    }

    @Test
    void testDocumentEntityFields() {
        assertEquals(1L, documentEntity.getId());
        assertEquals(123, documentEntity.getCorrespondent());
        assertEquals(456, documentEntity.getDocumentType());
        assertEquals(789, documentEntity.getStoragePath());
        assertEquals("Test Document", documentEntity.getTitle());
        assertEquals("This is a test document.", documentEntity.getContent());
        assertEquals(tags, documentEntity.getTags());
        assertNotNull(documentEntity.getCreated());
        assertNotNull(documentEntity.getCreatedDate());
        assertNotNull(documentEntity.getModified());
        assertNotNull(documentEntity.getAdded());
        assertEquals("ABC123", documentEntity.getArchiveSerialNumber());
        assertEquals("test.doc", documentEntity.getOriginalFileName());
        assertEquals("test_archived.doc", documentEntity.getArchivedFileName());
    }
}
*/
