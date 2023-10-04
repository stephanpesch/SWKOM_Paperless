package at.fhtw.swkom.paperless.persistance.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.openapitools.jackson.nullable.JsonNullable;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.OffsetDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CorrespondentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;

    private JsonNullable<String> slug = JsonNullable.<String>undefined();;

    private JsonNullable<String> name = JsonNullable.<String>undefined();

    private JsonNullable<String> match = JsonNullable.<String>undefined();

    private Long matchingAlgorithm;

    private Boolean isInsensitive;

    private Long documentCount;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private OffsetDateTime lastCorrespondence;

}
