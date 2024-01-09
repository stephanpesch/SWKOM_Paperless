package at.fhtw.swkom.paperless.persistance.entities;

import at.fhtw.swkom.paperless.services.dto.Correspondent;
import at.fhtw.swkom.paperless.services.dto.DocumentType;
import jakarta.persistence.*;
import java.time.OffsetDateTime;
import java.util.Set;

import lombok.*;


@Getter
@Setter
@Entity
@Table(name = "documents_document")
public class DocumentsDocumentEntity {

    @Id
    @Column(nullable = false, updatable = false)
    @SequenceGenerator(
            name = "primary_sequence",
            sequenceName = "primary_sequence",
            allocationSize = 1,
            initialValue = 10000
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "primary_sequence"
    )
    private Integer id;

    @Column(name = "title", nullable = false, length = 128)
    private String title;

    @Column(name = "content", nullable = false, columnDefinition = "TEXT")
    private String content;

    @Column(name = "created", nullable = false)
    private OffsetDateTime created;

    @Column(name = "modified", nullable = false)
    private OffsetDateTime modified;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "correspondent_id")
    private DocumentsCorrespondentEntity correspondent;

    @Column(name = "checksum", nullable = false, length = 32, unique = true)
    private String checksum;

    @Column(name = "added", nullable = false)
    private OffsetDateTime added;

    @Column(name = "storage_type", nullable = false, length = 11)
    private String storageType;

    @Column(name = "filename", length = 1024, unique = true)
    private String filename;

    @Column(name = "archive_serial_number", unique = true)
    private Integer archiveSerialNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "document_type_id")
    private DocumentsDocumentTypeEntity documentType;

    @Column(name = "mime_type", nullable = false, length = 256)
    private String mimeType;

    @Column(name = "archive_checksum", length = 32)
    private String archiveChecksum;

    @Column(name = "archive_filename", length = 1024, unique = true)
    private String archiveFilename;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "storage_path_id")
    private DocumentsStoragePathEntity storagePath;

    @Column(name = "original_filename", length = 1024)
    private String originalFilename;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private AuthUserEntity owner;


    @OneToMany(mappedBy = "document")
    private Set<DocumentsDocumentTagsEntity> documentsTag;

    @OneToMany(mappedBy = "document")
    private Set<DocumentsNoteEntity> notes;


}

