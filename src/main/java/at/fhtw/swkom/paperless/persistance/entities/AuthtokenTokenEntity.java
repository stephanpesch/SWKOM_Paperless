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
@Table(name = "authtoken_token")
public class AuthtokenTokenEntity {

    @Id
    @Column(name = "key", length = 40)
    private String key;

    @Column(name = "created", nullable = false)
    private OffsetDateTime created;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private AuthUserEntity user;

}

