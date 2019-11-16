package FinalProjectSecondService.Controllers;

import FinalProjectSecondService.DTO.PriceListDto;
import FinalProjectSecondService.Entities.PriceListEntity;
import FinalProjectSecondService.Services.PriceListSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pricelist")
public class PriceListController {

    @Autowired
    private PriceListSevice priceListSevice;

    @GetMapping("/{id}")
    @ResponseBody
    public PriceListEntity get(@PathVariable Long id){
        return priceListSevice.findById(id);
    }

    @PostMapping("")
    @ResponseBody
    public PriceListEntity create(@RequestBody PriceListDto priceListDto){
        return priceListSevice.create(priceListDto);
    }

    @PutMapping("")
    @ResponseBody
    public PriceListEntity update(@RequestBody PriceListDto priceListDto){
        return priceListSevice.update(priceListDto);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public void delete(@PathVariable Long id){
        priceListSevice.delete(id);
    }
}
