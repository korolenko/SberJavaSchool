package FinalProject.Entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@Data
@Table(name = "sparepart", schema = "catalog")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Accessors(chain = true)
public class SparePartEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@ManyToMany
    @Column(name = "sparepart")
    private String sparepart;

}
