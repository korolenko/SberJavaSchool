package FinalProjectSecondService.Controllers;

import FinalProjectSecondService.DTO.RepairListDTO;
import FinalProjectSecondService.Entities.RepairListEntity;
import FinalProjectSecondService.Services.RepairListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/repairlist")
public class RepaiListController {

    @Autowired
    private RepairListService repairListService;

    @GetMapping("/{id}")
    @ResponseBody
    public RepairListEntity get(@PathVariable Long id){
        return repairListService.findById(id);
    }

    @PostMapping("")
    @ResponseBody
    public RepairListEntity create(@RequestBody RepairListDTO repairListDTO){
        return repairListService.create(repairListDTO);
    }

    @PutMapping("")
    @ResponseBody
    public RepairListEntity update(@RequestBody RepairListDTO repairListDTO){
        return repairListService.update(repairListDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public void delete(@PathVariable Long id){
        repairListService.delete(id);
    }
}
