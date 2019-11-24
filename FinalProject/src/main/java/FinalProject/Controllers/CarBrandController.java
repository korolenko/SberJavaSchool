package FinalProject.Controllers;

import FinalProject.Entities.CarBrandEntity;
import FinalProject.Services.CarBrandService;
import FinalProject.dto.CarBrandDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/brand")
public class CarBrandController {

    @Autowired
    private CarBrandService carBrandService;

    @GetMapping("/{id}")
    @ResponseBody
    public CarBrandEntity get(@PathVariable Long id) {
        return carBrandService.findById(id);
    }

    @PostMapping("")
    @ResponseBody
    public CarBrandEntity create(@RequestBody CarBrandDto carBrandDto) {
        return carBrandService.create(carBrandDto);
    }

    @PutMapping("")
    @ResponseBody
    public CarBrandEntity update(@RequestBody CarBrandDto carBrandDto) {
        return carBrandService.update(carBrandDto);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public void delete(@PathVariable Long id){
        carBrandService.delete(id);
    }

    @CrossOrigin
    @GetMapping("/all")
    @ResponseBody
    public List<String> getAll(){
        return carBrandService.findAll();
    }
}
