package FinalProject.Services;

import FinalProject.Entities.CarModelEntity;
import FinalProject.Repositories.CarModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class CarModelService {

    @Autowired
    private CarModelRepository carModelRepository;

    public CarModelEntity findById(Long id){
        return carModelRepository.getOne(id);
    }

    public CarModelEntity create(CarModelEntity carModelEntity){
        return carModelRepository.save(carModelEntity);
    }

    public void delete(Long id){
        carModelRepository.delete(carModelRepository.getOne(id));
    }

    public  CarModelEntity update(Long id, String model){
        CarModelEntity carModelEntity = carModelRepository.getOne(id);
        carModelEntity.setManifacter(model);
        return carModelRepository.save(carModelEntity);
    }
}
