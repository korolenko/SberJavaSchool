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

    @Column(name = "brandid")
    private Long brandId;

    @Column(name = "modelid")
    private Long modelId;

    public LinksEntity(Long brandId, Long modelId){
        this.brandId = brandId;
        this.modelId = modelId;
    }

    public LinksEntity(){

    }
}
