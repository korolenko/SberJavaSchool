package FinalProject.Entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "model", schema = "catalog")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class CarModelEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "manufacter")
    private String manifacter;

    @Column(name = "model")
    private String model;
}
