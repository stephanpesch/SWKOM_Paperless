package at.fhtw.swkom.paperless.persistance.repositories;

import at.fhtw.swkom.paperless.persistance.entities.CorrespondentEntity;
import at.fhtw.swkom.paperless.persistance.entities.DocumentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface DocumentRepository extends JpaRepository<DocumentEntity,Integer> {

}
