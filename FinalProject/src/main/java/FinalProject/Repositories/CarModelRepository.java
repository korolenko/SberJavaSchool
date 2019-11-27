package FinalProject.Repositories;

import FinalProject.Entities.CarModelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarModelRepository extends JpaRepository<CarModelEntity,Long> {

    @Query("select m.model from CarModelEntity m\n" +
            "join LinksEntity l\n" +
            "on l.modelId = m.id\n" +
            "where l.brandId = :brandId")
    public List<String> findModelsByBrandId(@Param("brandId") Long brandId);
}
