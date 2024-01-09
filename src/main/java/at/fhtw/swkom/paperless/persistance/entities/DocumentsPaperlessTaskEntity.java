package at.fhtw.swkom.paperless.persistance.entities;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "documents_paperlesstask", uniqueConstraints = @UniqueConstraint(columnNames = "task_id"))
public class DocumentsPaperlessTaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "task_id", nullable = false, length = 255, unique = true)
    private String taskId;

    @Column(name = "acknowledged", nullable = false)
    private Boolean acknowledged;

    @Column(name = "date_created")
    private OffsetDateTime dateCreated;

    @Column(name = "date_done")
    private OffsetDateTime dateDone;

    @Column(name = "date_started")
    private OffsetDateTime dateStarted;

    @Column(name = "result", columnDefinition = "TEXT")
    private String result;

    @Column(name = "status", nullable = false, length = 30)
    private String status;

    @Column(name = "task_file_name", length = 255)
    private String taskFileName;

    @Column(name = "task_name", length = 255)
    private String taskName;

}

