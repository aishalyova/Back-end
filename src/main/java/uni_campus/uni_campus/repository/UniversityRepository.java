package uni_campus.uni_campus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uni_campus.uni_campus.model.University;

@Repository
public interface UniversityRepository extends JpaRepository<University, Integer> {
}
