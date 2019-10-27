package FinalProject.Controllers;

import FinalProject.Entities.CarBrandEntity;
import FinalProject.Services.CarBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carbrand")
public class CarBrandController {

    @Autowired
    private CarBrandService carBrandService;

    @GetMapping("/{id}")
    @ResponseBody
    public CarBrandEntity get(@PathVariable Long id) {
        return carBrandService.findById(id);
    }

    @PostMapping("create/{manufacter}")
    @ResponseBody
    public CarBrandEntity create(@PathVariable String manufacter) {
        CarBrandEntity carBrandEntity = new CarBrandEntity();
        carBrandEntity.setManifacter(manufacter);
        return carBrandService.create(carBrandEntity);
    }

    @PutMapping("update/{id}/{manufacter}")
    @ResponseBody
    public CarBrandEntity update(@PathVariable Long id, @PathVariable String manufacter){
        return carBrandService.update(id, manufacter);
    }

    @DeleteMapping("delete/{id}")
    @ResponseBody
    public void delete(@PathVariable Long id){
        carBrandService.delete(id);
    }
}
