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
@Table(name = "auth_group", uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class AuthGroupEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false, length = 150, unique = true)
    private String name;

    @OneToMany(mappedBy = "group")
    private Set<AuthUserGroupEntity> groupUserGroups;

    @OneToMany(mappedBy = "group")
    private Set<AuthUserGroupEntity> groupGroupPermissions;

}

