package homework8;

import homework8.dta.LaptopDTO;
import homework8.models.LaptopEntity;
import homework8.service.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/laptop")
public class HomeworkController {

    @Autowired
    private LaptopService laptopService;

    @GetMapping("/{id}")
    @ResponseBody
    public LaptopDTO get(@PathVariable Long id) {
        return laptopService.findById(id);
    }

    @GetMapping("create/{price}")
    @ResponseBody
    public LaptopEntity create(@PathVariable int price) {
        LaptopDTO laptopDTO = new LaptopDTO();
        laptopDTO.setPrice(price);
        return laptopService.create(laptopDTO);
    }

    @GetMapping("update/{id}/{price}")
    @ResponseBody
    public LaptopEntity update(@PathVariable Long id, @PathVariable int price){
        LaptopDTO laptopDTO = laptopService.findById(id);
        laptopDTO.setPrice(price);
        return laptopService.update(laptopDTO);
    }

    @GetMapping("delete/{id}")
    @ResponseBody
    public void delete(@PathVariable Long id){
        LaptopDTO laptopDTO = laptopService.findById(id);
        laptopService.delete(laptopDTO);
    }

    @GetMapping("/status/check")
    public String status() {
        return "working";
    }
}
