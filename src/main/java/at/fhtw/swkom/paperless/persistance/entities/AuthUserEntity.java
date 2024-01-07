package at.fhtw.swkom.paperless.persistance.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.OffsetDateTime;
import java.util.Set;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "auth_user")
public class AuthUserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "password", nullable = false, length = 128)
    private String password;

    @Column(name = "last_login")
    private OffsetDateTime lastLogin;

    @Column(name = "is_superuser", nullable = false)
    private Boolean isSuperuser;

    @Column(name = "username", nullable = false, length = 150, unique = true)
    private String username;

    @Column(name = "first_name", nullable = false, length = 150)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 150)
    private String lastName;

    @Column(name = "email", nullable = false, length = 254)
    private String email;

    @Column(name = "is_staff", nullable = false)
    private Boolean isStaff;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive;

    @Column(name = "date_joined", nullable = false)
    private OffsetDateTime dateJoined;

    @OneToMany(mappedBy = "user")
    private Set<AuthUserGroupEntity> userGroups;

    @OneToMany(mappedBy = "owner")
    private Set<DocumentsCorrespondentEntity> correspondents;

    @OneToMany(mappedBy = "owner")
    private Set<DocumentsDocumentTypeEntity> documentTypes;

    @OneToMany(mappedBy = "owner")
    private Set<DocumentsStoragePathEntity> storagePaths;

    @OneToMany(mappedBy = "owner")
    private Set<DocumentsTagEntity> documentsTags;

    @OneToMany(mappedBy = "user")
    private Set<DocumentsUISettingsEntity> uiSettings;

    @OneToMany(mappedBy = "owner")
    private Set<DocumentsSavedViewEntity> savedViews;

    @OneToMany(mappedBy = "owner")
    private Set<PaperlessMailMailaccountEntity> mailAccounts;

    @OneToMany(mappedBy = "owner")
    private Set<DocumentsDocumentEntity> documents;

    @OneToMany(mappedBy = "user")
    private Set<DocumentsNoteEntity> documentsNotes;

    @OneToMany(mappedBy = "owner")
    private Set<PaperlessMailMailruleEntity> mailRules;

    @OneToMany(mappedBy = "user")
    private Set<AuthUserUserPermissionsEntity> userPermissions;

    @OneToMany(mappedBy = "user")
    private Set<AuthtokenTokenEntity> authTokens;

    @OneToMany(mappedBy = "owner")
    private Set<PaperlessMailProcessedmailEntity> processedMails;

}

