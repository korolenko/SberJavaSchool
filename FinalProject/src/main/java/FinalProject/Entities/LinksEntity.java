package FinalProject.Entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@Data
@Table(name = "links", schema = "catalog")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Accessors(chain = true)
public class LinksEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(name = "sparepart")
    private String sparePart;

    public LinksEntity(String brand, String model, String sparePart){
        this.brand = brand;
        this.model = model;
        this.sparePart = sparePart;
    }

    public LinksEntity(){

    }
}
