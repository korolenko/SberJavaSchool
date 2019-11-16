package FinalProjectSecondService.Repositories;

import FinalProjectSecondService.Entities.PriceListEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceListRepository extends JpaRepository<PriceListEntity, Long> {
}
