package homework8;

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
    public LaptopEntity get(@PathVariable Long id) {
        return laptopService.findById(id);
    }

    @PostMapping("create/{price}")
    @ResponseBody
    public LaptopEntity create(@PathVariable int price) {
        LaptopEntity laptopEntity = new LaptopEntity();
        laptopEntity.setPrice(price);
        return laptopService.create(laptopEntity);
    }

    @PutMapping("update/{id}/{price}")
    @ResponseBody
    public LaptopEntity update(@PathVariable Long id, @PathVariable int price){
        return laptopService.update(id, price);
    }

    @DeleteMapping("delete/{id}")
    @ResponseBody
    public void delete(@PathVariable Long id){
        laptopService.delete(id);
    }

    @GetMapping("/status/check")
    public String status() {
        return "working";
    }
}
