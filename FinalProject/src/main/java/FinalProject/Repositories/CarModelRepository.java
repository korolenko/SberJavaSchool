package FinalProject.Repositories;

import FinalProject.Entities.CarModelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarModelRepository extends JpaRepository<CarModelEntity,Long> {
}
