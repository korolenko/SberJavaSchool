package FinalProject.Repositories;

import FinalProject.Entities.LinksEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LinksRepository extends JpaRepository<LinksEntity,Long> {
}
