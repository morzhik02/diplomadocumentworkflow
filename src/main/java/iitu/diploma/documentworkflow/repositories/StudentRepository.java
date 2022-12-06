package iitu.diploma.documentworkflow.repositories;

import iitu.diploma.documentworkflow.entities.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface StudentRepository extends JpaRepository<Students, Long> {
}
