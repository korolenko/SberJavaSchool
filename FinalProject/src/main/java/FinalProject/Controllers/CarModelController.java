package FinalProject.Controllers;


import FinalProject.Entities.CarModelEntity;
import FinalProject.Services.CarModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carmodel")
public class CarModelController {

    @Autowired
    private CarModelService carModelService;

    @GetMapping("/{id}")
    @ResponseBody
    public CarModelEntity get(@PathVariable Long id) {
        return carModelService.findById(id);
    }

    @PostMapping("create/{manufacter}/{model}")
    @ResponseBody
    public CarModelEntity create(@PathVariable String manufacter,@PathVariable String model) {
        CarModelEntity carModelEntity = new CarModelEntity();
        carModelEntity.setManifacter(manufacter);
        carModelEntity.setModel(model);
        return carModelService.create(carModelEntity);
    }

    @PutMapping("update/{id}/{model}")
    @ResponseBody
    public CarModelEntity update(@PathVariable Long id, @PathVariable String model){
        return carModelService.update(id, model);
    }

    @DeleteMapping("delete/{id}")
    @ResponseBody
    public void delete(@PathVariable Long id){
        carModelService.delete(id);
    }
}
