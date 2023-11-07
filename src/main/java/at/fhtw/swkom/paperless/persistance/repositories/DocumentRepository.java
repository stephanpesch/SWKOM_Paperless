package at.fhtw.swkom.paperless.persistance.repositories;

import at.fhtw.swkom.paperless.persistance.entities.CorrespondentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentRepository extends JpaRepository<CorrespondentEntity,Integer> {

}
