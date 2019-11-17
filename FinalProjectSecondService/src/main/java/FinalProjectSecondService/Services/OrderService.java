package FinalProjectSecondService.Services;

import FinalProjectSecondService.DTO.OrderDTO;
import FinalProjectSecondService.Entities.OrderEntity;
import FinalProjectSecondService.Repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public OrderEntity findById(Long id){
        return orderRepository.getOne(id);
    }

    public OrderEntity create(OrderDTO orderDTO){
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setClientId(orderDTO.getClientId());
        orderEntity.setMasterId(orderDTO.getMasterId());
        orderEntity.setUuid(orderDTO.getUuid());
        orderEntity.setRepairListId(orderDTO.getRepairListId());
        return orderRepository.save(orderEntity);
    }

    public OrderEntity update(OrderDTO orderDTO){
        OrderEntity orderEntity = orderRepository.getOne(orderDTO.getId());
        orderEntity.setClientId(orderDTO.getClientId());
        orderEntity.setMasterId(orderDTO.getMasterId());
        orderEntity.setUuid(orderDTO.getUuid());
        orderEntity.setRepairListId(orderDTO.getRepairListId());
        return orderRepository.save(orderEntity);
    }

    public void delete(Long id){
        orderRepository.delete(orderRepository.getOne(id));
    }
}
