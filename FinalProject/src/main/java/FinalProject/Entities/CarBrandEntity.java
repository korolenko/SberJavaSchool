package FinalProject.Entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;


@Entity
@Data
@Table(name = "brand", schema = "catalog")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Accessors(chain = true)
public class CarBrandEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "brand")
    private String brand;

}
