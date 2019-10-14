package homework8.repositories;

import homework8.models.LaptopEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LaptopRepository extends JpaRepository<LaptopEntity,Long> {
}
