package FinalProject.Services;

import FinalProject.Entities.CarBrandEntity;
import FinalProject.Repositories.CarBrandRepository;
import FinalProject.dto.CarBrandDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Transactional
@Service
public class CarBrandService {

    @Autowired
    private CarBrandRepository carBrandRepository;

    public CarBrandEntity findById(Long id){
        return carBrandRepository.getOne(id);
    }

    public Map<Long,String> findAll(){
        return carBrandRepository.findAll().stream()
                .collect(Collectors.toMap(CarBrandEntity::getId,CarBrandEntity::getBrand));
    }

    public CarBrandEntity create(CarBrandDto carBrandDto){
        return carBrandRepository.save(new CarBrandEntity().setBrand(carBrandDto.getBrand()));
    }

    public void delete(Long id){
        carBrandRepository.delete(carBrandRepository.getOne(id));
    }

    public  CarBrandEntity update(CarBrandDto carBrandDto){
        CarBrandEntity carBrandEntity = carBrandRepository.getOne(carBrandDto.getId());
        carBrandEntity.setBrand(carBrandDto.getBrand());
        return carBrandRepository.save(carBrandEntity);
    }
}
