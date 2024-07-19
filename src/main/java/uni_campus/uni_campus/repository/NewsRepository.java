package uni_campus.uni_campus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uni_campus.uni_campus.model.News;

@Repository
public interface NewsRepository extends JpaRepository<News,Integer> {
}
