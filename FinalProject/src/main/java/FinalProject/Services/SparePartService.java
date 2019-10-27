package FinalProject.Services;

import FinalProject.Entities.SparePartEntity;
import FinalProject.Repositories.SparePartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class SparePartService {

    @Autowired
    private SparePartRepository sparePartRepository;

    public SparePartEntity findById(Long id){
        return sparePartRepository.getOne(id);
    }

    public SparePartEntity create(SparePartEntity sparePartEntity){
        return sparePartRepository.save(sparePartEntity);
    }

    public void delete(Long id){
        sparePartRepository.delete(sparePartRepository.getOne(id));
    }

    public  SparePartEntity update(Long id, String name){
        SparePartEntity carModelEntity = sparePartRepository.getOne(id);
        carModelEntity.setName(name);
        return sparePartRepository.save(carModelEntity);
    }
}
