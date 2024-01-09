package at.fhtw.swkom.paperless.persistance.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;


@Setter
@Getter
@Entity
@Table(name = "auth_user_groups")
public class AuthUserGroupEntity {

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

    //@ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "user_id", nullable = false)
    //private AuthUserEntity user;

    //@ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "permission_id", nullable = false)
    //private AuthPermissionEntity permission;

}

