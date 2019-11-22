package FinalProjectSecondService.Services.integration.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class CatalogDto {

    private Long id;

    private String sparepart;
}
