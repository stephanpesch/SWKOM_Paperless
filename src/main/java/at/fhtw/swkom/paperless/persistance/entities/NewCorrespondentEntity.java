package at.fhtw.swkom.paperless.persistance.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.openapitools.jackson.nullable.JsonNullable;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.OffsetDateTime;

/*

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class NewCorrespondentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private String name ;

    private String match;

    private Long matchingAlgorithm;

    private Boolean isInsensitive;

    private Long documentCount;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private OffsetDateTime lastCorrespondence;

}
*/