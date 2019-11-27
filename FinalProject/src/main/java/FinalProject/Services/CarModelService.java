package FinalProject.Services;

import FinalProject.Entities.CarModelEntity;
import FinalProject.Repositories.CarModelRepository;
import FinalProject.dto.CarModelDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
public class CarModelService {

    @Autowired
    private CarModelRepository carModelRepository;

    public CarModelEntity findById(Long id){
        return carModelRepository.getOne(id);
    }


    public List<String> findAll(){
        return carModelRepository.findAll().stream()
                .map(CarModelEntity::getModel)
                .collect(Collectors.toList());
    }

    public List<String> findByBrandId(Long id){
        return carModelRepository.findModelsByBrandId(id);
    }

    public CarModelEntity create(CarModelDto carModelDto){
        return carModelRepository.save(new CarModelEntity().setModel(carModelDto.getModel()));
    }

    public void delete(Long id){
        carModelRepository.delete(carModelRepository.getOne(id));
    }

    public  CarModelEntity update(CarModelDto carModelDto){
        CarModelEntity carModelEntity = carModelRepository.getOne(carModelDto.getId());
        carModelEntity.setModel(carModelDto.getModel());
        return carModelRepository.save(carModelEntity);
    }
}
