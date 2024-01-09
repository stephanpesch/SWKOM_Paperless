package at.fhtw.swkom.paperless.services.Mapper;


import at.fhtw.swkom.paperless.persistance.entities.*;
import at.fhtw.swkom.paperless.persistance.repositories.*;
import at.fhtw.swkom.paperless.services.dto.Document;
import at.fhtw.swkom.paperless.services.mapper.DocumentMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.openapitools.jackson.nullable.JsonNullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class DocumentMapperTest {

    @Autowired
    private DocumentMapper documentMapper;

    @MockBean
    private DocumentsCorrespondentRepository documentsCorrespondentRepository;

    @MockBean
    private DocumentsDocumentTypeRepository documentsDocumentTypeRepository;

    @MockBean
    private DocumentsStoragePathRepository documentsStoragePathRepository;

    @MockBean
    private AuthUserRepository authUserRepository;

    @MockBean
    private DocumentsTagRepository documentsTagRepository;

    private DocumentsDocumentEntity documentEntity;
    private Document documentDto;


    @BeforeEach
    void setUp() {
        // Initialize your entity and DTO objects here
        documentEntity = new DocumentsDocumentEntity();
        // ... set properties for documentEntity
        documentEntity.setTitle("Test Title");
        documentEntity.setContent("Test Content");
        documentEntity.setCreated(OffsetDateTime.now(ZoneOffset.UTC));
        // ... similarly set other properties

        documentDto = new Document();
        // ... set properties for documentDto
        documentDto.setTitle(JsonNullable.of("Title"));
        documentDto.setContent(JsonNullable.of("Content"));
        documentDto.setCreated(OffsetDateTime.now(ZoneOffset.UTC));
        // ... similarly set other properties

        // Mock repository responses
        when(documentsCorrespondentRepository.findById(any())).thenReturn(Optional.of(new DocumentsCorrespondentEntity()));
        when(documentsDocumentTypeRepository.findById(any())).thenReturn(Optional.of(new DocumentsDocumentTypeEntity()));
        when(documentsStoragePathRepository.findById(any())).thenReturn(Optional.of(new DocumentsStoragePathEntity()));
        when(authUserRepository.findById(any())).thenReturn(Optional.of(new AuthUserEntity()));
    }

    @Test
    void shouldMapEntityToDto() {
        Document result = documentMapper.entityToDto(documentEntity);
        assertThat(result).isNotNull();
        assertThat(result.getTitle()).isEqualTo(documentEntity.getTitle());
        assertThat(result.getContent()).isEqualTo(documentEntity.getContent());
        // Add more assertions to validate other properties
    }

    @Test
    void shouldMapDtoToEntity() {
        DocumentsDocumentEntity result = documentMapper.dtoToEntity(documentDto);
        assertThat(result).isNotNull();
        assertThat(result.getTitle()).isEqualTo(documentDto.getTitle().orElse(null));
        assertThat(result.getContent()).isEqualTo(documentDto.getContent().orElse(null));
        // Add more assertions to validate other properties
    }

}
