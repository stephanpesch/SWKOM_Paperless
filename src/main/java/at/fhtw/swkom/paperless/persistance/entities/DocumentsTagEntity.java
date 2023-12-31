package at.fhtw.swkom.paperless.persistance.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "documents_tag", uniqueConstraints = @UniqueConstraint(columnNames = {"name", "owner_id"}))
public class DocumentsTagEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false, length = 128)
    private String name;

    @Column(name = "match", nullable = false, length = 256)
    private String match;

    @Column(name = "matching_algorithm", nullable = false)
    private Integer matchingAlgorithm;

    @Column(name = "is_insensitive", nullable = false)
    private Boolean isInsensitive;

    @Column(name = "is_inbox_tag", nullable = false)
    private Boolean isInboxTag;

    @Column(name = "color", nullable = false, length = 7)
    private String color;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private AuthUserEntity owner;

    @OneToMany(mappedBy = "tags")
    private Set<DocumentsDocumentTagsEntity> tagDocumentTags;

    @OneToMany(mappedBy = "tag")
    private Set<PaperlessMailMailruleAssignTagsEntity> tagMailRuleAssignTags;
}

