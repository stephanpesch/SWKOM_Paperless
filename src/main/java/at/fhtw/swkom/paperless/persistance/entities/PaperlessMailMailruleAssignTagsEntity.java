package at.fhtw.swkom.paperless.persistance.entities;


import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@Entity
@Table(name = "paperless_mail_mailrule_assign_tags", uniqueConstraints = @UniqueConstraint(columnNames = {"mailrule_id", "tag_id"}))
public class PaperlessMailMailruleAssignTagsEntity {

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mailrule_id", nullable = false)
    private PaperlessMailMailruleEntity mailrule;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tag_id", nullable = false)
    private DocumentsTagEntity tag;

}

