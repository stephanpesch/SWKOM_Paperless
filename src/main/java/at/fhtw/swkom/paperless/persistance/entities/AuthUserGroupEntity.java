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
@Table(name = "auth_user_groups", uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "group_id"}))
public class AuthUserGroupEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private AuthUserEntity user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id", nullable = false)
    private AuthGroupEntity group;

    @OneToMany(mappedBy = "group")
    private Set<AuthUserGroupEntity> groupUserGroups;

}

