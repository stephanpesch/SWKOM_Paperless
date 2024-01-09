package at.fhtw.swkom.paperless.persistance.entities;

import java.time.OffsetDateTime;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "paperless_mail_processedmail")
public class PaperlessMailProcessedmailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "folder", nullable = false, length = 256)
    private String folder;

    @Column(name = "uid", nullable = false, length = 256)
    private String uid;

    @Column(name = "subject", nullable = false, length = 256)
    private String subject;

    @Column(name = "received", nullable = false)
    private OffsetDateTime received;

    @Column(name = "processed", nullable = false)
    private OffsetDateTime processed;

    @Column(name = "status", nullable = false, length = 256)
    private String status;

    @Column(name = "error", columnDefinition = "TEXT")
    private String error;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private AuthUserEntity owner;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rule_id", nullable = false)
    private PaperlessMailMailruleEntity rule;

}

