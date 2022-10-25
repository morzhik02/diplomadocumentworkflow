package iitu.diploma.documentworkflow.repositories;

import iitu.diploma.documentworkflow.entities.Documents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface DocumentRepository extends JpaRepository<Documents, Long> {

    List<Documents> findAllByIdIsGreaterThan(Long id);
}
