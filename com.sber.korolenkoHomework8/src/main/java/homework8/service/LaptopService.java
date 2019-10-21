package homework8.service;

import homework8.models.LaptopEntity;
import homework8.repositories.LaptopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class LaptopService {

    @Autowired
    private LaptopRepository laptopRepository;

    public LaptopEntity findById(Long id){
        LaptopEntity laptopEntity = laptopRepository.getOne(id);
        return laptopEntity;
    }

    public LaptopEntity create(LaptopEntity laptopEntity){
        return laptopRepository.save(laptopEntity);
    }

    public LaptopEntity update(Long id, int price){
        LaptopEntity laptopEntity = laptopRepository.getOne(id);
        laptopEntity.setPrice(price);
        return laptopRepository.save(laptopEntity);
    }

    public void delete(Long id){
        LaptopEntity laptopEntity = laptopRepository.getOne(id);
        laptopRepository.delete(laptopEntity);
    }
}
