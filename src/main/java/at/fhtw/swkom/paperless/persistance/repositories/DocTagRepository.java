package at.fhtw.swkom.paperless.persistance.repositories;


import at.fhtw.swkom.paperless.persistance.entities.DocTagEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocTagRepository extends JpaRepository<DocTagEntity,Long> {
}
