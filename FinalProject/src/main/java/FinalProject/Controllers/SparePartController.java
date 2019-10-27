package FinalProject.Controllers;

import FinalProject.Entities.SparePartEntity;
import FinalProject.Services.SparePartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("create/{name}/{model}")
    @ResponseBody
    public SparePartEntity create(@PathVariable String name,@PathVariable String model) {
        SparePartEntity sparePartEntity = new SparePartEntity();
        sparePartEntity.setModel(model);
        sparePartEntity.setName(name);
        return sparePartService.create(sparePartEntity);
    }

    @PutMapping("update/{id}/{name}")
    @ResponseBody
    public SparePartEntity update(@PathVariable Long id, @PathVariable String name){
        return sparePartService.update(id, name);
    }

    @DeleteMapping("delete/{id}")
    @ResponseBody
    public void delete(@PathVariable Long id){
        sparePartService.delete(id);
    }
}

