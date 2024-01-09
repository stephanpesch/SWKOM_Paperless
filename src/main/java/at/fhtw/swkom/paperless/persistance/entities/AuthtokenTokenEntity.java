package at.fhtw.swkom.paperless.persistance.entities;

import java.time.OffsetDateTime;

import jakarta.persistence.*;
import lombok.*;



@Getter
@Setter
@Entity
@Table(name = "authtoken_token")
public class AuthtokenTokenEntity {

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

    private String key;

    @Column(name = "created", nullable = false)
    private OffsetDateTime created;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private AuthUserEntity user;

}

