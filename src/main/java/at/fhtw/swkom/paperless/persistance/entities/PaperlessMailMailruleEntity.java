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
@Table(name = "paperless_mail_mailrule", uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class PaperlessMailMailruleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false, length = 256, unique = true)
    private String name;

    @Column(name = "folder", nullable = false, length = 256)
    private String folder;

    @Column(name = "filter_from", length = 256)
    private String filterFrom;

    @Column(name = "filter_subject", length = 256)
    private String filterSubject;

    @Column(name = "filter_body", length = 256)
    private String filterBody;

    @Column(name = "maximum_age", nullable = false)
    private Integer maximumAge;

    @Column(name = "action", nullable = false)
    private Integer action;

    @Column(name = "action_parameter", length = 256)
    private String actionParameter;

    @Column(name = "assign_title_from", nullable = false)
    private Integer assignTitleFrom;

    @Column(name = "assign_correspondent_from", nullable = false)
    private Integer assignCorrespondentFrom;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", nullable = false)
    private PaperlessMailMailaccountEntity account;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assign_correspondent_id")
    private DocumentsCorrespondentEntity assignCorrespondent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assign_document_type_id")
    private DocumentsDocumentTypeEntity assignDocumentType;

    @Column(name = "order", nullable = false)
    private Integer order;

    @Column(name = "attachment_type", nullable = false)
    private Integer attachmentType;

    @Column(name = "filter_attachment_filename", length = 256)
    private String filterAttachmentFilename;

    @Column(name = "consumption_scope", nullable = false)
    private Integer consumptionScope;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private AuthUserEntity owner;

    @Column(name = "filter_to", length = 256)
    private String filterTo;

    @OneToMany(mappedBy = "rule")
    private Set<PaperlessMailProcessedmailEntity> rulePaperlessMail;

    @OneToMany(mappedBy = "mailrule")
    private Set<PaperlessMailMailruleAssignTagsEntity> mailrulePaperlessMailTags;

}

