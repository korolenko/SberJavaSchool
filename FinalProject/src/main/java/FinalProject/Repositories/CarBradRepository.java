package FinalProject.Repositories;

import FinalProject.Entities.CarBrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarBradRepository extends JpaRepository<CarBrandEntity,Long> {
}
