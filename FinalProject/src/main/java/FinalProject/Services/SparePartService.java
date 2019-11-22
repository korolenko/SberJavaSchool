package FinalProject.Services;

import FinalProject.Entities.SparePartEntity;
import FinalProject.Repositories.SparePartRepository;
import FinalProject.dto.SparePartDto;
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

    public SparePartEntity create(SparePartDto sparePartDto){
        SparePartEntity sparePartEntity = new SparePartEntity();
        sparePartEntity.setSparepart(sparePartDto.getSparepart());
        return sparePartRepository.save(sparePartEntity);
    }

    public void delete(Long id){
        sparePartRepository.delete(sparePartRepository.getOne(id));
    }

    public  SparePartEntity update(SparePartDto sparePartDto){
        SparePartEntity carModelEntity = sparePartRepository.getOne(sparePartDto.getId());
        carModelEntity.setSparepart(sparePartDto.getSparepart());
        return sparePartRepository.save(carModelEntity);
    }
}
