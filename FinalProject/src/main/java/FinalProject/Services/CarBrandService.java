package FinalProject.Services;

import FinalProject.Entities.CarBrandEntity;
import FinalProject.Repositories.CarBradRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class CarBrandService {

    @Autowired
    private CarBradRepository carBradRepository;

    public CarBrandEntity findById(Long id){
        return carBradRepository.getOne(id);
    }

    public CarBrandEntity create(CarBrandEntity carBrandEntity){
        return carBradRepository.save(carBrandEntity);
    }

    public void delete(Long id){
        carBradRepository.delete(carBradRepository.getOne(id));
    }

    public  CarBrandEntity update(Long id, String manufacter){
        CarBrandEntity carBrandEntity = carBradRepository.getOne(id);
        carBrandEntity.setManifacter(manufacter);
        return carBradRepository.save(carBrandEntity);
    }
}
