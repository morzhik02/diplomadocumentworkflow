package iitu.diploma.documentworkflow.repositories;

import iitu.diploma.documentworkflow.entities.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface EmployeeRepository extends JpaRepository<Employees, Long> {
}
