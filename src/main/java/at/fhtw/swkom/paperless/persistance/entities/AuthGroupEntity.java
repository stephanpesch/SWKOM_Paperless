package at.fhtw.swkom.paperless.persistance.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "auth_group", uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class AuthGroupEntity {

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

    @Column(name = "name", nullable = false, length = 150, unique = true)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id", nullable = false)
    private AuthGroupEntity group;

    //@OneToMany(mappedBy = "user")
    //private Set<AuthUserUserPermissionsEntity> UserUserPermissions;

}

