package FinalProject.Repositories;


import FinalProject.Entities.SparePartEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SparePartRepository extends JpaRepository<SparePartEntity,Long> {
}
