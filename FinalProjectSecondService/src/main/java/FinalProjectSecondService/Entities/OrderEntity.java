package FinalProjectSecondService.Entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
@Table(name = "order", schema = "\"order\"")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Accessors(chain = true)
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "uuid")
    private UUID uuid;

    @Column(name = "clientid")
    private Long clientId;

    @Column(name = "masterid")
    private Long masterId;

    @Column(name = "repairlistid")
    private Long repairListId;


//    @OneToMany(cascade = CascadeType.ALL)
//    private Set<RepairListEntity> repairListEntities;
}
