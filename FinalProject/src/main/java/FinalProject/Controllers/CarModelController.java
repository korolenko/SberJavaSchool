package FinalProject.Controllers;


import FinalProject.Entities.CarModelEntity;
import FinalProject.Services.CarModelService;
import FinalProject.dto.CarModelDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/model")
public class CarModelController {

    @Autowired
    private CarModelService carModelService;

    @GetMapping("/{id}")
    @ResponseBody
    public CarModelEntity get(@PathVariable Long id) {
        return carModelService.findById(id);
    }

    @RequestMapping(value = "/brandid/{brandId}", method = RequestMethod.GET)
    public List<String> getModelsByBrandId(@PathVariable Long brandId){
        return carModelService.findByBrandId(brandId);
    }

    @PostMapping("")
    @ResponseBody
    public CarModelEntity create(@RequestBody CarModelDto carModelDto) {
        return carModelService.create(carModelDto);
    }

    @PutMapping("")
    @ResponseBody
    public CarModelEntity update(@RequestBody CarModelDto carModelDto){
        return carModelService.update(carModelDto);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public void delete(@PathVariable Long id){
        carModelService.delete(id);
    }

    @CrossOrigin
    @GetMapping("/all")
    @ResponseBody
    public List<String> getAll(){
        return carModelService.findAll();
    }
}
