package homework8.service;

import homework8.dta.LaptopDTO;
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

    public LaptopDTO findById(Long id){
        LaptopEntity laptopEntity = laptopRepository.getOne(id);
        LaptopDTO laptopDTO = new LaptopDTO();
        laptopDTO.setId(laptopEntity.getId());
        laptopDTO.setModel(laptopEntity.getModel());
        laptopDTO.setManifacter(laptopEntity.getManifacter());
        laptopDTO.setPrice(laptopEntity.getPrice());
        return laptopDTO;
    }

    public LaptopEntity create(LaptopDTO laptopDTO){
        LaptopEntity laptopEntity = new LaptopEntity();
        laptopEntity.setModel(laptopDTO.getModel());
        laptopEntity.setManifacter(laptopDTO.getModel());
        laptopEntity.setPrice(laptopDTO.getPrice());
        return laptopRepository.save(laptopEntity);
    }

    public LaptopEntity update(LaptopDTO laptopDTO){
        LaptopEntity laptopEntity = laptopRepository.getOne(laptopDTO.getId());
        laptopEntity.setPrice(laptopDTO.getPrice());
        return laptopRepository.save(laptopEntity);
    }

    public void delete(LaptopDTO laptopDTO){
        LaptopEntity laptopEntity = laptopRepository.getOne(laptopDTO.getId());
        laptopRepository.delete(laptopEntity);
    }
}
