package at.fhtw.swkom.paperless.persistance.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.Set;


@Setter
@Getter
@Entity
@Table(name = "auth_permission", uniqueConstraints = @UniqueConstraint(columnNames = {"id", "codename"}))
public class AuthPermissionEntity {

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

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(name = "content_type", nullable = false, length = 100)
    private String contentType;

    @Column(name = "codename", nullable = false, length = 100)
    private String codename;

   // @OneToMany(mappedBy = "permission")
    //private Set<AuthUserUserPermissionsEntity> permissionGroupPermissions;

   // @OneToMany(mappedBy = "permission")
   // private Set<AuthUserUserPermissionsEntity> permissionUserPermissions;

}

