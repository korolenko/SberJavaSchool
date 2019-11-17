package FinalProjectSecondService.Repositories;

import FinalProjectSecondService.Entities.MasterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MasterRepository extends JpaRepository<MasterEntity, Long> {
}
