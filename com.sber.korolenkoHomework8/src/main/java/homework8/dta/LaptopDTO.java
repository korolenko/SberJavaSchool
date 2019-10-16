package homework8.dta;

import lombok.Data;

import java.util.Objects;

@Data
public class LaptopDTO {
    private Long id;
    private String manifacter;
    private String model;
    private int price;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LaptopDTO laptopDTO = (LaptopDTO) o;
        return Objects.equals(id, laptopDTO.id) &&
                Objects.equals(manifacter, laptopDTO.manifacter) &&
                Objects.equals(model, laptopDTO.model) &&
                Objects.equals(price, laptopDTO.price);
    }

    @Override
    public int hashCode() {
        return 1;
    }
}
