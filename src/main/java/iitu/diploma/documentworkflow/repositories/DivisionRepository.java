package iitu.diploma.documentworkflow.repositories;

import iitu.diploma.documentworkflow.entities.Divisions;
import iitu.diploma.documentworkflow.entities.Groups;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface DivisionRepository extends JpaRepository<Divisions, Long> {
}
