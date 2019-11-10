package FinalProject.Entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;


@Entity
@Data
@Table(name = "carbrand", schema = "catalog")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class CarBrandEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "manufacter")
    private String manifacter;

}
