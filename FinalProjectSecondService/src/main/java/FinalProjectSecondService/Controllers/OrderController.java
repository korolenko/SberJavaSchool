package FinalProjectSecondService.Controllers;

import FinalProjectSecondService.DTO.OrderDTO;
import FinalProjectSecondService.Entities.OrderEntity;
import FinalProjectSecondService.Services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/{id}")
    @ResponseBody
    public OrderEntity get(@PathVariable Long id){
        return orderService.findById(id);
    }

    @PostMapping("")
    @ResponseBody
    public OrderEntity create(@RequestBody OrderDTO orderDTO){
        return orderService.create(orderDTO);
    }

    @PutMapping("")
    @ResponseBody
    public OrderEntity update(@RequestBody OrderDTO orderDTO){
        return orderService.update(orderDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public void delete(@PathVariable Long id){
        orderService.delete(id);
    }
}
