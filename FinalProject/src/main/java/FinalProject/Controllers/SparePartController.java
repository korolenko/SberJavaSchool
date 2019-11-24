package FinalProject.Controllers;

import FinalProject.Entities.SparePartEntity;
import FinalProject.Services.SparePartService;
import FinalProject.dto.SparePartDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sparepart")
public class SparePartController {

    @Autowired
    private SparePartService sparePartService;

    @GetMapping("/{id}")
    @ResponseBody
    public SparePartEntity get(@PathVariable Long id) {
        return sparePartService.findById(id);
    }

    @PostMapping("")
    @ResponseBody
    public SparePartEntity create(@RequestBody SparePartDto sparePartDto) {
        return sparePartService.create(sparePartDto);
    }

    @PutMapping("")
    @ResponseBody
    public SparePartEntity update(@RequestBody SparePartDto sparePartDto){
        return sparePartService.update(sparePartDto);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public void delete(@PathVariable Long id){
        sparePartService.delete(id);
    }

    @CrossOrigin
    @GetMapping("/all")
    @ResponseBody
    public List<String> getAll(){
        return sparePartService.findAll();
    }
}

