package at.fhtw.swkom.paperless.persistance.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;


@Getter
@Setter
@Entity
@Table(name = "documents_storagepath", uniqueConstraints = {@UniqueConstraint(columnNames = {"name", "owner_id"})})
public class DocumentsStoragePathEntity {

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

    @Column(name = "name", nullable = false, length = 128)
    private String name;

    @Column(name = "match", nullable = false, length = 256)
    private String match;

    @Column(name = "matching_algorithm", nullable = false)
    private Integer matchingAlgorithm;

    @Column(name = "is_insensitive", nullable = false)
    private Boolean isInsensitive;

    @Column(name = "path", nullable = false, length = 512)
    private String path;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private AuthUserEntity owner;

    @OneToMany(mappedBy = "storagePath")
    private Set<DocumentsDocumentEntity> storagePathDocuments;

}

