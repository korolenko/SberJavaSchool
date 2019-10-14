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
        return laptopRepository.getOne(id);
    }

    public LaptopEntity create(LaptopEntity laptopEntity){
        return laptopRepository.save(laptopEntity);
    }
}
