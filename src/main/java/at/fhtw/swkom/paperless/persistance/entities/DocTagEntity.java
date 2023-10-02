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

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class DocTagEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;

    private String slug;

    private String name;

    private String color;

    private String match;

    private Long matchingAlgorithm;

    private Boolean isInsensitive;

    private Boolean isInboxTag;

    private Long documentCount;


}
