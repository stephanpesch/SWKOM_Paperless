package at.fhtw.swkom.paperless.model;

import java.time.OffsetDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.openapitools.jackson.nullable.JsonNullable;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Entity
@Table
@Data
public class Correspondent {

	@Id
	private Long id;

	@Column
	private Long matchingAlgorithm;

	@Column
	private Boolean isInsensitive;

	@Column
	private Long documentCount;

	@Column
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private OffsetDateTime lastCorrespondence;

}
