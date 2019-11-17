package FinalProjectSecondService.DTO;

import lombok.Data;

import java.util.UUID;

@Data
public class OrderDTO {

    private Long id;
    private UUID uuid;
    private Long clientId;
    private Long masterId;
    private Long repairListId;
}
