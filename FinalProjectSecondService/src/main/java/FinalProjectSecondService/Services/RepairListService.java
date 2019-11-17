package FinalProjectSecondService.Services;


import FinalProjectSecondService.DTO.RepairListDTO;
import FinalProjectSecondService.Entities.RepairListEntity;
import FinalProjectSecondService.Repositories.RepairListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class RepairListService {

    @Autowired
    private RepairListRepository repairListRepository;

    public RepairListEntity findById(Long id){
        return repairListRepository.getOne(id);
    }

    public RepairListEntity create(RepairListDTO repairListDTO){
        RepairListEntity repairListEntity = new RepairListEntity();
        repairListEntity.setOrderId(repairListDTO.getOrderId());
        repairListEntity.setPricelistId(repairListDTO.getPricelistId());
        return repairListRepository.save(repairListEntity);
    }

    public RepairListEntity update(RepairListDTO repairListDTO){
        RepairListEntity repairListEntity = repairListRepository.getOne(repairListDTO.getId());
        repairListEntity.setOrderId(repairListDTO.getOrderId());
        repairListEntity.setPricelistId(repairListDTO.getPricelistId());
        return repairListRepository.save(repairListEntity);
    }

    public void delete(Long id){
        repairListRepository.delete(repairListRepository.getOne(id));
    }
}
