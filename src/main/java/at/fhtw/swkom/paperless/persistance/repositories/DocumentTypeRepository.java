package at.fhtw.swkom.paperless.persistance.repositories;

import at.fhtw.swkom.paperless.persistance.entities.DocumentTypeEntity;
import at.fhtw.swkom.paperless.services.dto.DocumentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentTypeRepository extends JpaRepository<DocumentTypeEntity, Long> {
}
