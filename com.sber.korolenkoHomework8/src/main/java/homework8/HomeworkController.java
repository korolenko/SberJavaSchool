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

    @GetMapping("create/{price}")
    @ResponseBody
    public LaptopEntity create(@PathVariable int price) {
        LaptopEntity laptopEntity = new LaptopEntity();
        laptopEntity.setPrice(price);
        return laptopService.create(laptopEntity);
    }

    //@RequestMapping("/")
    //public String index(){
    //return "Hello Spring world";
    // }

    @GetMapping("/status/check")
    public String status() {
        return "working";
    }
}
