package FinalProject.Services;

import FinalProject.Entities.CarModelEntity;
import FinalProject.Repositories.CarModelRepository;
import FinalProject.dto.CarModelDto;
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
